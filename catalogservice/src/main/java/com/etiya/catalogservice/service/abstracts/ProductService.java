package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateProductRequest;
import com.etiya.catalogservice.service.responses.product.CreatedProductResponse;
import com.etiya.catalogservice.service.responses.product.GetListProductResponse;

import java.util.List;

public interface ProductService {
    CreatedProductResponse add(CreateProductRequest request);
    List<GetListProductResponse> getList();
}
