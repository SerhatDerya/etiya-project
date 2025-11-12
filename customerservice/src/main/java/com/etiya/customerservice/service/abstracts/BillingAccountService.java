package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.UpdatedBillingAccountResponse;

import java.util.List;
import java.util.UUID;

public interface BillingAccountService {
    CreatedBillingAccountResponse add(CreateBillingAccountRequest request);
    List<GetListBillingAccountResponse> getList();
    UpdatedBillingAccountResponse update(UUID id,UpdateBillingAccountRequest request);
    void delete(UUID id);
}
