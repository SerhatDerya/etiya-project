package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.CampaignService;
import com.etiya.catalogservice.service.requests.CreateCampaignRequest;
import com.etiya.catalogservice.service.responses.campaign.CreatedCampaignResponse;
import com.etiya.catalogservice.service.responses.campaign.GetListCampaignResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns/")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCampaignResponse add(@Valid @RequestBody CreateCampaignRequest request) {
        return campaignService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCampaignResponse> getList() {
        return campaignService.getList();
    }
}
