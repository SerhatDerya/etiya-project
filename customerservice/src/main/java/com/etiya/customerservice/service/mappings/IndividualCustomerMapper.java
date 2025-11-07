package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.customer.CreateCustomerEvent;
import com.etiya.common.events.customer.UpdateCustomerEvent;
import com.etiya.customerservice.domain.entities.IndividualCustomer;
import com.etiya.customerservice.service.requests.customer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.requests.customer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.UpdatedIndividualCustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
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

    void individualCustomerFromUpdateIndividualCustomerRequest(UpdateIndividualCustomerRequest request,@MappingTarget IndividualCustomer individualCustomer);

    UpdatedIndividualCustomerResponse updatedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    UpdateCustomerEvent updateCustomerEventFromIndividualCustomer(IndividualCustomer individualCustomer);
}
