package com.etiya.catalogservice.service.mappings;


import com.etiya.catalogservice.domain.entities.CampaignProduct;
import com.etiya.catalogservice.service.requests.CreateCampaignProductRequest;
import com.etiya.catalogservice.service.responses.campaign.CreatedCampaignResponse;
import com.etiya.catalogservice.service.responses.campaignProduct.CreatedCampaignProductResponse;
import com.etiya.catalogservice.service.responses.campaignProduct.GetListCampaignProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignProductMapper {
    CampaignProductMapper INSTANCE = Mappers.getMapper(CampaignProductMapper.class);

    @Mapping(target = "campaign.id",source = "campaignId")
    @Mapping(target = "product.id",source = "productId")
    CampaignProduct campaignProductFromCreateCampaignProductRequest(CreateCampaignProductRequest request);

    @Mapping(target = "campaignId",source = "campaign.id")
    @Mapping(target = "productId",source = "product.id")
    CreatedCampaignProductResponse createdCampaignProductResponseFromCampaignProduct(CampaignProduct campaignProduct);

    @Mapping(target = "campaignId",source = "campaign.id")
    @Mapping(target = "productId",source = "product.id")
    GetListCampaignProductResponse getListCampaignProductResponseFromCampaign(CampaignProduct campaignProducts);
    List<GetListCampaignProductResponse> getListCampaignProductResponseFromCampaign(List<CampaignProduct> campaignProducts);


}
