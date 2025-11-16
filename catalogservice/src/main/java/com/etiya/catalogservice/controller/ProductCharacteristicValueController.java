package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.ProductCharacteristicValueService;
import com.etiya.catalogservice.service.requests.CreateProductCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.CreatedProductCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.GetListProductCharacteristicValueResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_characteristic_values/")
public class ProductCharacteristicValueController {
    private final ProductCharacteristicValueService productCharacteristicValueService;

    public ProductCharacteristicValueController(ProductCharacteristicValueService productCharacteristicValueService) {
        this.productCharacteristicValueService = productCharacteristicValueService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductCharacteristicValueResponse add(@Valid @RequestBody CreateProductCharacteristicValueRequest request) {
        return productCharacteristicValueService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListProductCharacteristicValueResponse> getList() {
        return productCharacteristicValueService.getList();
    }
}
