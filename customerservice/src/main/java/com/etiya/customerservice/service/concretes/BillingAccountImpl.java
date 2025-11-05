package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.CreateBillingAccountEvent;
import com.etiya.customerservice.domain.entities.BillingAccount;
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
public class BillingAccountImpl implements BillingAccountService {

    private final BillingAccountRepository billingAccountRepository;
    private final CreateBillingAccountProducer createBillingAccountProducer;

    public BillingAccountImpl(BillingAccountRepository billingAccountRepository, CreateBillingAccountProducer createBillingAccountProducer) {
        this.billingAccountRepository = billingAccountRepository;
        this.createBillingAccountProducer = createBillingAccountProducer;
    }

    @Override
    public CreatedBillingAccountResponse add(CreateBillingAccountRequest request) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromCreateBillingAccountRequest(request);
        BillingAccount result = billingAccountRepository.save(billingAccount);
        CreateBillingAccountEvent  event = BillingAccountMapper.INSTANCE.createBillingAccountEventFromBillingAccount(result);
        createBillingAccountProducer.produceBillingAccountCreated(event);
        CreatedBillingAccountResponse response = BillingAccountMapper.INSTANCE.createdBillingAccountResponseFromBillingAccount(result);
        return  response;
    }

    @Override
    public List<GetListBillingAccountResponse> getList() {
        List<BillingAccount> billingAccounts = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getListBillingAccountResponseFromBillingAccount(billingAccounts);
    }
}
