package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;

import java.util.List;
import java.util.UUID;

public interface BillingAccountService {
    CreatedBillingAccountResponse add(CreateBillingAccountRequest request);
    List<GetListBillingAccountResponse> getList();
    void delete(UUID id);
}
