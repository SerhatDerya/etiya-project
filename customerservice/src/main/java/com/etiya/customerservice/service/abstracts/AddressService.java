package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.address.CreateAddressRequest;
import com.etiya.customerservice.service.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.service.responses.address.CreatedAddressResponse;
import com.etiya.customerservice.service.responses.address.GetListAddressResponse;
import com.etiya.customerservice.service.responses.address.UpdatedAddressResponse;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    CreatedAddressResponse add(CreateAddressRequest request);
    List<GetListAddressResponse> getList();
    UpdatedAddressResponse update(UUID id,UpdateAddressRequest request);
    void delete(UUID id);
}
