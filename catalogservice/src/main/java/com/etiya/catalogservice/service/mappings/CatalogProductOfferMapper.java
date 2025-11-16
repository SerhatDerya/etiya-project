package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.CatalogProductOffer;
import com.etiya.catalogservice.service.requests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.service.responses.catalogProductOffer.CreatedCatalogProductOfferResponse;
import com.etiya.catalogservice.service.responses.catalogProductOffer.GetListCatalogProductOfferResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CatalogProductOfferMapper {
    CatalogProductOfferMapper INSTANCE = Mappers.getMapper(CatalogProductOfferMapper.class);

    @Mapping(target = "catalog.id",source = "catalogId")
    @Mapping(target = "productOffer.id",source = "productOfferId")
    CatalogProductOffer catalogProductOfferFromCreateCatalogProductOfferRequest(CreateCatalogProductOfferRequest request);

    @Mapping(target = "catalogId",source = "catalog.id")
    @Mapping(target = "productOfferId",source = "productOffer.id")
    CreatedCatalogProductOfferResponse createdCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);

    @Mapping(target = "catalogId",source = "catalog.id")
    @Mapping(target = "productOfferId",source = "productOffer.id")
    GetListCatalogProductOfferResponse  getListCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffers);
    List<GetListCatalogProductOfferResponse>  getListCatalogProductOfferResponseFromCatalogProductOffer(List<CatalogProductOffer> catalogProductOffers);
}
