package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.billingAccount.CreateBillingAccountEvent;
import com.etiya.common.events.billingAccount.DeleteBillingAccountEvent;
import com.etiya.common.events.billingAccount.UpdateBillingAccountEvent;
import com.etiya.common.responses.BillingAccountResponse;
import com.etiya.customerservice.domain.entities.*;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.repository.BillingAccountRepository;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.mappings.BillingAccountMapper;
import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.UpdatedBillingAccountResponse;
import com.etiya.customerservice.service.rules.AddressBusinessRules;
import com.etiya.customerservice.service.rules.BillingAccountBusinessRules;
import com.etiya.customerservice.service.rules.CustomerBusinessRules;
import com.etiya.customerservice.transport.kafka.producer.billingAccount.CreateBillingAccountProducer;
import com.etiya.customerservice.transport.kafka.producer.billingAccount.DeleteBillingAccountProducer;
import com.etiya.customerservice.transport.kafka.producer.billingAccount.UpdateBillingAccountProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {

    private final BillingAccountRepository billingAccountRepository;
    private final AddressRepository addressRepository;
    private final CreateBillingAccountProducer createBillingAccountProducer;
    private final DeleteBillingAccountProducer deleteBillingAccountProducer;
    private final CustomerBusinessRules customerBusinessRules;
    private final AddressBusinessRules addressBusinessRules;
    private final BillingAccountBusinessRules billingAccountBusinessRules;
    private final UpdateBillingAccountProducer updateBillingAccountProducer;

    public BillingAccountServiceImpl(BillingAccountRepository billingAccountRepository, AddressRepository addressRepository, CreateBillingAccountProducer createBillingAccountProducer, DeleteBillingAccountProducer deleteBillingAccountProducer, CustomerBusinessRules customerBusinessRules, AddressBusinessRules addressBusinessRules, BillingAccountBusinessRules billingAccountBusinessRules, UpdateBillingAccountProducer updateBillingAccountProducer) {
        this.billingAccountRepository = billingAccountRepository;
        this.addressRepository = addressRepository;
        this.createBillingAccountProducer = createBillingAccountProducer;
        this.deleteBillingAccountProducer = deleteBillingAccountProducer;
        this.customerBusinessRules = customerBusinessRules;
        this.addressBusinessRules = addressBusinessRules;
        this.billingAccountBusinessRules = billingAccountBusinessRules;
        this.updateBillingAccountProducer = updateBillingAccountProducer;
    }

    @Override
    public CreatedBillingAccountResponse add(CreateBillingAccountRequest request) {
        customerBusinessRules.checkIfCustomerNotDeleted(request.getCustomerId());
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromCreateBillingAccountRequest(request);
        billingAccountBusinessRules.setDefaultStatusIfNull(billingAccount);
        billingAccountBusinessRules.setDefaultTypeIfNull(billingAccount);
        BillingAccount result = billingAccountRepository.save(billingAccount);
        BillingAccount fullAccount = billingAccountBusinessRules.getBillingAccountWithStatusAndTypeIfExists(result.getId());
        CreateBillingAccountEvent  event = BillingAccountMapper.INSTANCE.createBillingAccountEventFromBillingAccount(fullAccount);
        createBillingAccountProducer.produceBillingAccountCreated(event);
        CreatedBillingAccountResponse response = BillingAccountMapper.INSTANCE.createdBillingAccountResponseFromBillingAccount(result);
        return  response;

    }

    @Override
    public List<GetListBillingAccountResponse> getList() {
        List<BillingAccount> billingAccounts = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getListBillingAccountResponseFromBillingAccount(billingAccounts);
    }

    @Override
    public UpdatedBillingAccountResponse update(UUID id, UpdateBillingAccountRequest request) {
        BillingAccount billingAccount = billingAccountBusinessRules.getBillingAccountIfExists(id);
        BillingAccountMapper.INSTANCE.billingAccountFromUpdateBillingAccountRequest(request, billingAccount);
        Address address = addressBusinessRules.getAddressIfExists(request.getAddressId());
        billingAccount.setAddress(address);
        BillingAccount result = billingAccountRepository.save(billingAccount);
        BillingAccount fullAccount = billingAccountBusinessRules.getBillingAccountWithStatusAndTypeIfExists(result.getId());
        billingAccount.setUpdatedDate(LocalDateTime.now());
        UpdateBillingAccountEvent   event = BillingAccountMapper.INSTANCE.updateBillingAccountEventFromBillingAccount(fullAccount);
        updateBillingAccountProducer.produceBillingAccountUpdated(event);
        UpdatedBillingAccountResponse response = BillingAccountMapper.INSTANCE.updatedBillingAccountResponseFromBillingAccount(result);
        return  response;

    }

    @Override
    public void delete(UUID id) {
        BillingAccount billingAccount = billingAccountBusinessRules.getBillingAccountIfExists(id);
        billingAccountBusinessRules.setClosedStatus(billingAccount);
        billingAccount.setDeletedDate(LocalDateTime.now());
        DeleteBillingAccountEvent event = new DeleteBillingAccountEvent(
                billingAccount.getId().toString(),
                billingAccount.getCustomer().getId().toString()
        );
        deleteBillingAccountProducer.produceBillingAccountDeleted(event);
        billingAccountRepository.save(billingAccount);
    }

    @Override
    public BillingAccountResponse getById(UUID id) {
        BillingAccount billingAccount = billingAccountBusinessRules.getBillingAccountIfExists(id);
        return BillingAccountMapper.INSTANCE.billingAccountResponseFromBillingAccount(billingAccount);
    }
}
