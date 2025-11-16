package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.CampaignProduct;
import com.etiya.catalogservice.repository.CampaignProductRepository;
import com.etiya.catalogservice.service.abstracts.CampaignProductService;
import com.etiya.catalogservice.service.mappings.CampaignProductMapper;
import com.etiya.catalogservice.service.requests.CreateCampaignProductRequest;
import com.etiya.catalogservice.service.responses.campaignProduct.CreatedCampaignProductResponse;
import com.etiya.catalogservice.service.responses.campaignProduct.GetListCampaignProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignProductServiceImpl implements CampaignProductService {
    private final CampaignProductRepository campaignProductRepository;

    public CampaignProductServiceImpl(CampaignProductRepository campaignProductRepository) {
        this.campaignProductRepository = campaignProductRepository;
    }

    @Override
    public CreatedCampaignProductResponse add(CreateCampaignProductRequest request) {
        CampaignProduct campaignProduct = CampaignProductMapper.INSTANCE.campaignProductFromCreateCampaignProductRequest(request);
        CampaignProduct result = campaignProductRepository.save(campaignProduct);
        CreatedCampaignProductResponse response = CampaignProductMapper.INSTANCE.createdCampaignProductResponseFromCampaignProduct(result);
        return response;
    }

    @Override
    public List<GetListCampaignProductResponse> getList() {
        List<CampaignProduct> campaignProducts = campaignProductRepository.findAll();
        return CampaignProductMapper.INSTANCE.getListCampaignProductResponseFromCampaign(campaignProducts);
    }
}
