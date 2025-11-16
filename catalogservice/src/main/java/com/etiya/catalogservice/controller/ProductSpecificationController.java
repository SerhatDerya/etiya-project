package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.ProductSpecificationService;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationRequest;
import com.etiya.catalogservice.service.responses.productSpecification.CreatedProductSpecificationResponse;
import com.etiya.catalogservice.service.responses.productSpecification.GetListProductSpecificationResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_specifications/")
public class ProductSpecificationController {
    private final ProductSpecificationService productSpecificationService;

    public ProductSpecificationController(ProductSpecificationService productSpecificationService) {
        this.productSpecificationService = productSpecificationService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductSpecificationResponse add(@Valid @RequestBody CreateProductSpecificationRequest request) {
        return productSpecificationService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListProductSpecificationResponse> getList() {
        return productSpecificationService.getList();
    }
}
