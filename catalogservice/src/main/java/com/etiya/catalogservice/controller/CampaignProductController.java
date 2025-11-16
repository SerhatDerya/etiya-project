package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.CampaignProductService;
import com.etiya.catalogservice.service.requests.CreateCampaignProductRequest;
import com.etiya.catalogservice.service.responses.campaignProduct.CreatedCampaignProductResponse;
import com.etiya.catalogservice.service.responses.campaignProduct.GetListCampaignProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign_products/")
public class CampaignProductController {
    private final CampaignProductService campaignProductService;

    public CampaignProductController(CampaignProductService campaignProductService) {
        this.campaignProductService = campaignProductService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCampaignProductResponse add(@Valid @RequestBody CreateCampaignProductRequest request) {
        return campaignProductService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCampaignProductResponse> getList() {
        return campaignProductService.getList();
    }
}
