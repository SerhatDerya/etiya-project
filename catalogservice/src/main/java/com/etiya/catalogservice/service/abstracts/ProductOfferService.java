package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.domain.entities.ProductOffer;
import com.etiya.catalogservice.service.requests.CreateProductOfferRequest;
import com.etiya.catalogservice.service.responses.productOffer.CreatedProductOfferResponse;
import com.etiya.catalogservice.service.responses.productOffer.GetListProductOfferResponse;

import java.util.List;
import java.util.UUID;

public interface ProductOfferService {
    CreatedProductOfferResponse add(CreateProductOfferRequest request);
    List<GetListProductOfferResponse> getList();
    List<GetListProductOfferResponse> getListByCatalogId(UUID id);
}
