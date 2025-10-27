package com.etiya.customerservice.service.mappings;

import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.service.requests.customers.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.individualcustomers.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.individualcustomers.GetListCustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "motherName", target = "motherName")
    @Mapping(source = "fatherName", target = "fatherName")
    @Mapping(source = "natId", target = "natId")
    Customer createCustomerRequestToCustomer(CreateCustomerRequest createCustomerRequest);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "motherName", target = "motherName")
    @Mapping(source = "fatherName", target = "fatherName")
    @Mapping(source = "natId", target = "natId")
    CreatedCustomerResponse customerToCreatedCustomerResponse(Customer customer);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "motherName", target = "motherName")
    @Mapping(source = "fatherName", target = "fatherName")
    @Mapping(source = "natId", target = "natId")
    GetListCustomerResponse customerToGetListCustomerResponse(Customer customer);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "motherName", target = "motherName")
    @Mapping(source = "fatherName", target = "fatherName")
    @Mapping(source = "natId", target = "natId")
    List<GetListCustomerResponse>  getListCustomerResponseFromCustomer(List<Customer> customers);
}
