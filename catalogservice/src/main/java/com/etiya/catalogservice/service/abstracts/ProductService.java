package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateProductRequest;
import com.etiya.catalogservice.service.responses.product.CreatedProductResponse;
import com.etiya.catalogservice.service.responses.product.GetListProductResponse;
import com.etiya.common.responses.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    CreatedProductResponse add(CreateProductRequest request);
    List<GetListProductResponse> getList();
    CreatedProductResponse getById(UUID id);

    ProductResponse getProductById(UUID id);
}
