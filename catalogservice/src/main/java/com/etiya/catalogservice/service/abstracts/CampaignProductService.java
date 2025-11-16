package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateCampaignProductRequest;
import com.etiya.catalogservice.service.responses.campaignProduct.CreatedCampaignProductResponse;
import com.etiya.catalogservice.service.responses.campaignProduct.GetListCampaignProductResponse;

import java.util.List;

public interface CampaignProductService {
    CreatedCampaignProductResponse add(CreateCampaignProductRequest request);
    List<GetListCampaignProductResponse> getList();
}
