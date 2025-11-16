package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.CatalogProductOfferService;
import com.etiya.catalogservice.service.requests.CreateCampaignProductRequest;
import com.etiya.catalogservice.service.requests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.service.responses.catalogProductOffer.CreatedCatalogProductOfferResponse;
import com.etiya.catalogservice.service.responses.catalogProductOffer.GetListCatalogProductOfferResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog_product_offers/")
public class CatalogProductOfferController {
    private final CatalogProductOfferService catalogProductOfferService;

    public CatalogProductOfferController(CatalogProductOfferService catalogProductOfferService) {
        this.catalogProductOfferService = catalogProductOfferService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCatalogProductOfferResponse add(@Valid @RequestBody CreateCatalogProductOfferRequest request) {
        return catalogProductOfferService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCatalogProductOfferResponse> getList() {
        return catalogProductOfferService.getList();
    }
}
