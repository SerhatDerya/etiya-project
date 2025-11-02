package com.etiya.customerservice.service.abstracts.customer;

import com.etiya.customerservice.service.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest request);
    List<GetListCustomerResponse> getList();
}
