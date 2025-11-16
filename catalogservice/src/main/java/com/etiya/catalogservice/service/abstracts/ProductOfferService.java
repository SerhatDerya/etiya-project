package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.domain.entities.ProductOffer;
import com.etiya.catalogservice.service.requests.CreateProductOfferRequest;
import com.etiya.catalogservice.service.responses.productOffer.CreatedProductOfferResponse;
import com.etiya.catalogservice.service.responses.productOffer.GetListProductOfferResponse;

import java.util.List;

public interface ProductOfferService {
    CreatedProductOfferResponse add(CreateProductOfferRequest request);
    List<GetListProductOfferResponse> getList();
}
