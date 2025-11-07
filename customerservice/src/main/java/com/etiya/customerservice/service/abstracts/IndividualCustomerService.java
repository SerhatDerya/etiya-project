package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.customer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.requests.customer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.UpdatedIndividualCustomerResponse;

import java.util.List;
import java.util.UUID;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest request);
    List<GetListIndividualCustomerResponse> getList();
    void delete(UUID id);
    UpdatedIndividualCustomerResponse update(UUID id, UpdateIndividualCustomerRequest request);
}
