package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.address.CreateAddressEvent;
import com.etiya.common.events.address.UpdateAddressEvent;
import com.etiya.customerservice.domain.entities.Address;
import com.etiya.customerservice.service.requests.address.CreateAddressRequest;
import com.etiya.customerservice.service.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.service.responses.address.CreatedAddressResponse;
import com.etiya.customerservice.service.responses.address.GetListAddressResponse;
import com.etiya.customerservice.service.responses.address.UpdatedAddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "city.id",source = "cityId")
    @Mapping(target = "customer.id",source = "customerId")
    Address addressFromCreateAddressRequest(CreateAddressRequest request);

    @Mapping(target = "cityName",source = "city.name")
    @Mapping(target = "cityId",source = "city.id")
    @Mapping(target = "customerId",source = "customer.id")
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);

    @Mapping(target = "cityName",source = "city.name")
    @Mapping(target = "cityId",source = "city.id")
    @Mapping(target = "customerId",source = "customer.id")
    GetListAddressResponse getListAddressResponseFromAddress(Address address);
    List<GetListAddressResponse> getListAddressResponseFromAddress(List<Address> address);

    @Mapping(target = "cityName",source = "city.name")
    @Mapping(target = "cityId",source = "city.id")
    @Mapping(target = "customerId",source = "customer.id")
    CreateAddressEvent createAddressEventFromAddress(Address address);


    @Mapping(target = "city.id",source = "cityId")
    @Mapping(target = "customer.id",source = "customerId")
    void addressFromUpdateAddressRequest(UpdateAddressRequest request, @MappingTarget Address address);

    @Mapping(target = "cityName",source = "city.name")
    @Mapping(target = "cityId",source = "city.id")
    @Mapping(target = "customerId",source = "customer.id")
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);

    @Mapping(target = "cityName",source = "city.name")
    @Mapping(target = "cityId",source = "city.id")
    @Mapping(target = "customerId",source = "customer.id")
    UpdateAddressEvent updateAddressEventFromAddress(Address address);
}
