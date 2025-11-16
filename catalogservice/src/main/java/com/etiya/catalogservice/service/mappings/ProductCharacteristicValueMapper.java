package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.ProductCharacteristicValue;
import com.etiya.catalogservice.service.requests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.service.requests.CreateProductCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.CreatedProductCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.GetListProductCharacteristicValueResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductCharacteristicValueMapper {
    ProductCharacteristicValueMapper INSTANCE = Mappers.getMapper(ProductCharacteristicValueMapper.class);



    @Mapping(target = "characteristicValue.id",source = "charValueId")
    @Mapping(target = "product.id",source = "productId")
    ProductCharacteristicValue productCharacteristicValueFromCreateProductCharacteristicValueRequest(CreateProductCharacteristicValueRequest request);

    @Mapping(target = "charValueId",source = "characteristicValue.id")
    @Mapping(target = "productId",source = "product.id")
    CreatedProductCharacteristicValueResponse createdProductCharacteristicValueResponseFromProductCharacteristicValue(ProductCharacteristicValue productCharacteristicValue);

    @Mapping(target = "charValueId",source = "characteristicValue.id")
    @Mapping(target = "productId",source = "product.id")
    GetListProductCharacteristicValueResponse getListProductCharacteristicValueResponseFromProductCharacteristicValue(ProductCharacteristicValue productCharacteristicValues);
    List<GetListProductCharacteristicValueResponse> getListProductCharacteristicValueResponseFromProductCharacteristicValue(List<ProductCharacteristicValue> productCharacteristicValues);
}
