package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.domain.entities.ProductSpecification;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationRequest;
import com.etiya.catalogservice.service.responses.productSpecification.CreatedProductSpecificationResponse;
import com.etiya.catalogservice.service.responses.productSpecification.GetListProductSpecificationResponse;

import java.util.List;

public interface ProductSpecificationService {
    CreatedProductSpecificationResponse add(CreateProductSpecificationRequest request);
    List<GetListProductSpecificationResponse> getList();
}
