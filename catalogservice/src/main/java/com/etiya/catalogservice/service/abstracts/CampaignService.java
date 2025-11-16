package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.domain.entities.Campaign;
import com.etiya.catalogservice.service.requests.CreateCampaignRequest;
import com.etiya.catalogservice.service.responses.campaign.CreatedCampaignResponse;
import com.etiya.catalogservice.service.responses.campaign.GetListCampaignResponse;

import java.util.List;

public interface CampaignService  {
    CreatedCampaignResponse add(CreateCampaignRequest request);
    List<GetListCampaignResponse> getList();
}
