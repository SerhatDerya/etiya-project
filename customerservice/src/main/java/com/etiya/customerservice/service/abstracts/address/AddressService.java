package com.etiya.customerservice.service.abstracts.address;

import com.etiya.customerservice.service.requests.address.CreateAddressRequest;
import com.etiya.customerservice.service.responses.address.CreatedAddressResponse;
import com.etiya.customerservice.service.responses.address.GetListAddressResponse;

import java.util.List;

public interface AddressService {
    CreatedAddressResponse add(CreateAddressRequest request);
    List<GetListAddressResponse> getList();
}
