package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.CreateCustomerEvent;
import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.service.requests.customers.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.customers.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.customers.GetListCustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    Customer customerFromCreateCustomerRequest (CreateCustomerRequest request);

    CreatedCustomerResponse createdCustomerResponseFromCustomer(Customer customer);

    CreateCustomerEvent createCustomerEventFromCustomer(Customer customer);


//    GetListCustomerResponse getListCustomerResponseFromCustomer(Customer customer);
    List<GetListCustomerResponse> getListCustomerResponseFromCustomer(List<Customer> customers);
}
