package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.customers.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.customers.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.customers.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest request);
    List<GetListCustomerResponse> getList();
}
