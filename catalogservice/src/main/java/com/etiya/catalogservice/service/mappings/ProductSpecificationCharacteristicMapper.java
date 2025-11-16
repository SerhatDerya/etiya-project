package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.ProductSpecificationCharacteristic;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationCharacteristicRequest;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.CreatedProductCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.productSpecificationCharacteristic.CreatedProductSpecificationCharacteristicResponse;
import com.etiya.catalogservice.service.responses.productSpecificationCharacteristic.GetListProductSpecificationCharacteristicResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductSpecificationCharacteristicMapper {
    ProductSpecificationCharacteristicMapper INSTANCE = Mappers.getMapper(ProductSpecificationCharacteristicMapper.class);

    @Mapping(target = "productSpecification.id",source = "specId")
    @Mapping(target = "characteristic.id",source = "charId")
    ProductSpecificationCharacteristic productSpecificationCharacteristicFromCreateProductSpecificationCharacteristicRequest(CreateProductSpecificationCharacteristicRequest request);

    @Mapping(target = "specId",source = "productSpecification.id")
    @Mapping(target = "charId",source = "characteristic.id")
    CreatedProductSpecificationCharacteristicResponse createdProductSpecificationCharacteristicResponseFromProductSpecificationCharacteristic(ProductSpecificationCharacteristic productSpecificationCharacteristic);

    @Mapping(target = "specId",source = "productSpecification.id")
    @Mapping(target = "charId",source = "characteristic.id")
    GetListProductSpecificationCharacteristicResponse getListProductSpecificationCharacteristicResponseFromProductSpecificationCharacteristic(ProductSpecificationCharacteristic productSpecificationCharacteristics);
    List<GetListProductSpecificationCharacteristicResponse> getListProductSpecificationCharacteristicResponseFromProductSpecificationCharacteristic(List<ProductSpecificationCharacteristic> productSpecificationCharacteristics);
}
