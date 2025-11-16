package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.ProductOfferService;
import com.etiya.catalogservice.service.requests.CreateProductOfferRequest;
import com.etiya.catalogservice.service.responses.productOffer.CreatedProductOfferResponse;
import com.etiya.catalogservice.service.responses.productOffer.GetListProductOfferResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_offers/")
public class ProductOfferController {
    private final ProductOfferService productOfferService;

    public ProductOfferController(ProductOfferService productOfferService) {
        this.productOfferService = productOfferService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductOfferResponse add(@Valid @RequestBody CreateProductOfferRequest request) {
        return productOfferService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListProductOfferResponse> getList() {
        return productOfferService.getList();
    }
}
