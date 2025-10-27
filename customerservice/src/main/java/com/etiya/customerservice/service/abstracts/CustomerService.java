package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.customers.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.individualcustomers.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.individualcustomers.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest request);
    List<GetListCustomerResponse> getList();
}
