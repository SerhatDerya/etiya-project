package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.ProductService;
import com.etiya.catalogservice.service.requests.CreateProductRequest;
import com.etiya.catalogservice.service.responses.product.CreatedProductResponse;
import com.etiya.catalogservice.service.responses.product.GetListProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@Valid @RequestBody CreateProductRequest request) {
        return productService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListProductResponse> getList() {
        return productService.getList();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreatedProductResponse getById(@PathVariable UUID id){
        return productService.getById(id);
    }
}
