package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.billingAccount.CreateBillingAccountEvent;
import com.etiya.common.events.billingAccount.DeleteBillingAccountEvent;
import com.etiya.common.events.billingAccount.UpdateBillingAccountEvent;
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
import com.etiya.customerservice.service.rules.customer.BillingAccountBusinessRules;
import com.etiya.customerservice.service.rules.customer.CustomerBusinessRules;
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
    private final BillingAccountBusinessRules billingAccountBusinessRules;
    private final UpdateBillingAccountProducer updateBillingAccountProducer;

    public BillingAccountServiceImpl(BillingAccountRepository billingAccountRepository, AddressRepository addressRepository, CreateBillingAccountProducer createBillingAccountProducer, DeleteBillingAccountProducer deleteBillingAccountProducer, CustomerBusinessRules customerBusinessRules, BillingAccountBusinessRules billingAccountBusinessRules, UpdateBillingAccountProducer updateBillingAccountProducer) {
        this.billingAccountRepository = billingAccountRepository;
        this.addressRepository = addressRepository;
        this.createBillingAccountProducer = createBillingAccountProducer;
        this.deleteBillingAccountProducer = deleteBillingAccountProducer;
        this.customerBusinessRules = customerBusinessRules;
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
        BillingAccount fullAccount = billingAccountRepository.findByIdWithAccount(result.getId())
                .orElseThrow(() -> new RuntimeException("Status or Type missing"));
        CreateBillingAccountEvent  event = BillingAccountMapper.INSTANCE.createBillingAccountEventFromBillingAccount(fullAccount);
        createBillingAccountProducer.produceBillingAccountCreated(event);
        CreatedBillingAccountResponse response = BillingAccountMapper.INSTANCE.createdBillingAccountResponseFromBillingAccount(result);
        return  response;
//        BillingAccount billingAccount = new BillingAccount();
//        billingAccount.setAccountName(request.getAccountName());
//        Customer customer = new Customer();
//        customer.setId(request.getCustomerId());
//        billingAccount.setCustomer(customer);
//        Address address = new Address();
//        address.setId(request.getAddressId());
//        billingAccount.setAddress(address);
//        Status status = new Status();
//        status.setId(request.getStatusId());
//        billingAccount.setStatus(status);
//        Type type = new Type();
//        type.setId(request.getTypeId());
//        billingAccount.setType(type);
//        BillingAccount result = billingAccountRepository.save(billingAccount);
//        BillingAccount fullAccount = billingAccountRepository.findByIdWithAccount(result.getId())
//        .orElseThrow(() -> new RuntimeException("Status or Type missing"));
//
//        CreateBillingAccountEvent event = new CreateBillingAccountEvent(
//                fullAccount.getId().toString(),
//                fullAccount.getCustomer().getId().toString(),
//                fullAccount.getAddress().getId().toString(),
//                fullAccount.getStatus().getId().toString(),
//                fullAccount.getType().getId().toString(),
//                fullAccount.getAccountNumber(),
//                fullAccount.getAccountName(),
//                fullAccount.getType().getName(),
//                fullAccount.getStatus().getName());
//        createBillingAccountProducer.produceBillingAccountCreated(event);
//        CreatedBillingAccountResponse response = new CreatedBillingAccountResponse();
//        response.setId(result.getId());
//        return response;
//



    }

    @Override
    public List<GetListBillingAccountResponse> getList() {
        List<BillingAccount> billingAccounts = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getListBillingAccountResponseFromBillingAccount(billingAccounts);
    }

    @Override
    public UpdatedBillingAccountResponse update(UUID id, UpdateBillingAccountRequest request) {
        BillingAccount billingAccount = billingAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Billing Account not found"));
        BillingAccountMapper.INSTANCE.billingAccountFromUpdateBillingAccountRequest(request, billingAccount);
        Address address = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));
        billingAccount.setAddress(address);
        BillingAccount result = billingAccountRepository.save(billingAccount);
        BillingAccount fullAccount = billingAccountRepository.findByIdWithAccount(result.getId())
                .orElseThrow(() -> new RuntimeException("Status or Type missing"));
        billingAccount.setUpdatedDate(LocalDateTime.now());
        UpdateBillingAccountEvent   event = BillingAccountMapper.INSTANCE.updateBillingAccountEventFromBillingAccount(fullAccount);
        updateBillingAccountProducer.produceBillingAccountUpdated(event);
        UpdatedBillingAccountResponse response = BillingAccountMapper.INSTANCE.updatedBillingAccountResponseFromBillingAccount(result);
        return  response;

    }

    @Override
    public void delete(UUID id) {
        BillingAccount billingAccount = billingAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Billing Account not found"));
        billingAccountBusinessRules.setClosedStatus(billingAccount);
        billingAccount.setDeletedDate(LocalDateTime.now());
        DeleteBillingAccountEvent event = new DeleteBillingAccountEvent(
                billingAccount.getId().toString(),
                billingAccount.getCustomer().getId().toString()
        );
        deleteBillingAccountProducer.produceBillingAccountDeleted(event);
        billingAccountRepository.save(billingAccount);
    }
}
