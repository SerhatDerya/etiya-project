package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.Campaign;
import com.etiya.catalogservice.repository.CampaignRepository;
import com.etiya.catalogservice.service.abstracts.CampaignService;
import com.etiya.catalogservice.service.mappings.CampaignMapper;
import com.etiya.catalogservice.service.requests.CreateCampaignRequest;
import com.etiya.catalogservice.service.responses.campaign.CreatedCampaignResponse;
import com.etiya.catalogservice.service.responses.campaign.GetListCampaignResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public CreatedCampaignResponse add(CreateCampaignRequest request) {
        Campaign campaign = CampaignMapper.INSTANCE.campaignFromCreateCampaignRequest(request);
        Campaign result = campaignRepository.save(campaign);
        CreatedCampaignResponse response = CampaignMapper.INSTANCE.createdCampaignResponseFromCampaign(result);
        return response;
    }

    @Override
    public List<GetListCampaignResponse> getList() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return CampaignMapper.INSTANCE.getListCampaignResponseFromCampaign(campaigns);
    }
}
