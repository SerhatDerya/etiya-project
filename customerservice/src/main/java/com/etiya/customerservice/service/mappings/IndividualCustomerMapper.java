package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.CreateCustomerEvent;
import com.etiya.customerservice.domain.entities.IndividualCustomer;
import com.etiya.customerservice.service.requests.customer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListIndividualCustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IndividualCustomerMapper {

    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    IndividualCustomer individualCustomerFromCreateIndividualCustomerRequest (CreateIndividualCustomerRequest request);

    CreatedIndividualCustomerResponse createdIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    CreateCustomerEvent createCustomerEventFromIndividualCustomer(IndividualCustomer individualCustomer);

    GetListIndividualCustomerResponse getListIndividualCustomerResponseFromCustomer(IndividualCustomer individualCustomers);
    List<GetListIndividualCustomerResponse> getListIndividualCustomerResponseFromCustomer(List<IndividualCustomer> individualCustomers);
}
