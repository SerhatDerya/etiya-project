package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.Product;
import com.etiya.catalogservice.service.requests.CreateProductRequest;
import com.etiya.catalogservice.service.responses.product.CreatedProductResponse;
import com.etiya.catalogservice.service.responses.product.GetListProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "productSpecification.id",source = "specId")
    @Mapping(target = "catalog.id",source = "catalogId")
    Product productFromCreateProductRequest(CreateProductRequest createProductRequest);

    @Mapping(target = "specId",source = "productSpecification.id")
    @Mapping(target = "catalogId",source = "catalog.id")
    CreatedProductResponse createdProductResponseFromProduct(Product product);

    @Mapping(target = "specId",source = "productSpecification.id")
    @Mapping(target = "catalogId",source = "catalog.id")
    GetListProductResponse getListProductResponseFromProduct(Product products);
    List<GetListProductResponse> getListProductResponseFromProduct(List<Product> products);
}
