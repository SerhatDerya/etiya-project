package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.ProductSpecificationCharacteristicService;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationCharacteristicRequest;
import com.etiya.catalogservice.service.responses.productSpecificationCharacteristic.CreatedProductSpecificationCharacteristicResponse;
import com.etiya.catalogservice.service.responses.productSpecificationCharacteristic.GetListProductSpecificationCharacteristicResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_specification_characteristics/")
public class ProductSpecificationCharacteristicController {
    private final ProductSpecificationCharacteristicService productSpecificationCharacteristicService;

    public ProductSpecificationCharacteristicController(ProductSpecificationCharacteristicService productSpecificationCharacteristicService) {
        this.productSpecificationCharacteristicService = productSpecificationCharacteristicService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductSpecificationCharacteristicResponse add(@Valid @RequestBody CreateProductSpecificationCharacteristicRequest request) {
        return productSpecificationCharacteristicService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListProductSpecificationCharacteristicResponse> getList() {
        return productSpecificationCharacteristicService.getList();
    }
}
