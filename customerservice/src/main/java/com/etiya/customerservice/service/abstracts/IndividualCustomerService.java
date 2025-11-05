package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.customer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest request);
    List<GetListIndividualCustomerResponse> getList();
}
