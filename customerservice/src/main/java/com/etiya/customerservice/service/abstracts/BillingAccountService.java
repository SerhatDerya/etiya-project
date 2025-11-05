package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;

import java.util.List;

public interface BillingAccountService {
    CreatedBillingAccountResponse add(CreateBillingAccountRequest request);
    List<GetListBillingAccountResponse> getList();
}
