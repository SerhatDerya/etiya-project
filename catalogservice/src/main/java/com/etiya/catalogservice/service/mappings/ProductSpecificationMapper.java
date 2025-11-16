package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.ProductSpecification;
import com.etiya.catalogservice.domain.entities.ProductSpecificationCharacteristic;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationRequest;
import com.etiya.catalogservice.service.responses.productSpecification.CreatedProductSpecificationResponse;
import com.etiya.catalogservice.service.responses.productSpecification.GetListProductSpecificationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductSpecificationMapper {
    ProductSpecificationMapper INSTANCE = Mappers.getMapper(ProductSpecificationMapper.class);


    ProductSpecification productSpecificationFromCreateProductSpecificationRequest(CreateProductSpecificationRequest request);

    CreatedProductSpecificationResponse createdProductSpecificationResponseFromProductSpecification(ProductSpecification productSpecification);


    List<GetListProductSpecificationResponse> getListProductSpecificationResponseFromProductSpecification(List<ProductSpecification> productSpecifications);
}
