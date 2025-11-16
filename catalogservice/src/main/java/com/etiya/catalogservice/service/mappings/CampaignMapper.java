package com.etiya.catalogservice.service.mappings;


import com.etiya.catalogservice.domain.entities.Campaign;
import com.etiya.catalogservice.service.requests.CreateCampaignRequest;
import com.etiya.catalogservice.service.responses.campaign.CreatedCampaignResponse;
import com.etiya.catalogservice.service.responses.campaign.GetListCampaignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);

    Campaign campaignFromCreateCampaignRequest(CreateCampaignRequest request);

    CreatedCampaignResponse createdCampaignResponseFromCampaign(Campaign campaign);


    List<GetListCampaignResponse> getListCampaignResponseFromCampaign(List<Campaign> campaigns);


}
