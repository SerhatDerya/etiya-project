package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateProductCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.CreatedProductCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.GetListProductCharacteristicValueResponse;

import java.util.List;

public interface ProductCharacteristicValueService {
    CreatedProductCharacteristicValueResponse add(CreateProductCharacteristicValueRequest request);
    List<GetListProductCharacteristicValueResponse> getList();
}
