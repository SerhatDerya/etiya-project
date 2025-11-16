package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.ProductOffer;
import com.etiya.catalogservice.service.requests.CreateProductOfferRequest;
import com.etiya.catalogservice.service.responses.productOffer.CreatedProductOfferResponse;
import com.etiya.catalogservice.service.responses.productOffer.GetListProductOfferResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductOfferMapper {
    ProductOfferMapper INSTANCE = Mappers.getMapper(ProductOfferMapper.class);

    @Mapping(target = "product.id",source = "productId")
    ProductOffer productOfferFromCreateProductOfferRequest(CreateProductOfferRequest request);

    @Mapping(target = "productId",source = "product.id")
    CreatedProductOfferResponse createdProductOfferResponseFromProductOffer(ProductOffer productOffer);

    @Mapping(target = "productId",source = "product.id")
    GetListProductOfferResponse getListProductOfferResponseFromProductOffer(ProductOffer productOffers);
    List<GetListProductOfferResponse> getListProductOfferResponseFromProductOffer(List<ProductOffer> productOffers);
}
