package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.CreateBillingAccountEvent;
import com.etiya.customerservice.domain.entities.*;
import com.etiya.customerservice.repository.BillingAccountRepository;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.mappings.BillingAccountMapper;
import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;
import com.etiya.customerservice.transport.kafka.producer.billingAccount.CreateBillingAccountProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {

    private final BillingAccountRepository billingAccountRepository;
    private final CreateBillingAccountProducer createBillingAccountProducer;

    public BillingAccountServiceImpl(BillingAccountRepository billingAccountRepository, CreateBillingAccountProducer createBillingAccountProducer) {
        this.billingAccountRepository = billingAccountRepository;
        this.createBillingAccountProducer = createBillingAccountProducer;
    }

    @Override
    public CreatedBillingAccountResponse add(CreateBillingAccountRequest request) {
//        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromCreateBillingAccountRequest(request);
//        BillingAccount result = billingAccountRepository.save(billingAccount);
//        BillingAccount fullAccount = billingAccountRepository.findByIdWithAccount(result.getId())
//                .orElseThrow(() -> new RuntimeException("Status or Type missing"));
//        CreateBillingAccountEvent  event = BillingAccountMapper.INSTANCE.createBillingAccountEventFromBillingAccount(fullAccount);
//        createBillingAccountProducer.produceBillingAccountCreated(event);
//        CreatedBillingAccountResponse response = BillingAccountMapper.INSTANCE.createdBillingAccountResponseFromBillingAccount(result);
//        return  response;
        BillingAccount billingAccount = new BillingAccount();
        billingAccount.setAccountName(request.getAccountName());
        Customer customer = new Customer();
        customer.setId(request.getCustomerId());
        billingAccount.setCustomer(customer);
        Address address = new Address();
        address.setId(request.getAddressId());
        billingAccount.setAddress(address);
        Status status = new Status();
        status.setId(request.getStatusId());
        billingAccount.setStatus(status);
        Type type = new Type();
        type.setId(request.getTypeId());
        billingAccount.setType(type);
        BillingAccount result = billingAccountRepository.save(billingAccount);
        BillingAccount fullAccount = billingAccountRepository.findByIdWithAccount(result.getId())
        .orElseThrow(() -> new RuntimeException("Status or Type missing"));

        CreateBillingAccountEvent event = new CreateBillingAccountEvent(
                fullAccount.getId().toString(),
                fullAccount.getCustomer().getId().toString(),
                fullAccount.getAddress().getId().toString(),
                fullAccount.getStatus().getId().toString(),
                fullAccount.getType().getId().toString(),
                fullAccount.getAccountNumber(),
                fullAccount.getAccountName(),
                fullAccount.getType().getName(),
                fullAccount.getStatus().getName());
        createBillingAccountProducer.produceBillingAccountCreated(event);
        CreatedBillingAccountResponse response = new CreatedBillingAccountResponse();
        response.setId(result.getId());
        return response;




    }

    @Override
    public List<GetListBillingAccountResponse> getList() {
        List<BillingAccount> billingAccounts = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getListBillingAccountResponseFromBillingAccount(billingAccounts);
    }
}
