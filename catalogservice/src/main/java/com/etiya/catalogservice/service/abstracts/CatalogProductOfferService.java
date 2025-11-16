package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.service.responses.catalog.GetListCatalogResponse;
import com.etiya.catalogservice.service.responses.catalogProductOffer.CreatedCatalogProductOfferResponse;
import com.etiya.catalogservice.service.responses.catalogProductOffer.GetListCatalogProductOfferResponse;

import java.util.List;

public interface CatalogProductOfferService {
    CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest request);
    List<GetListCatalogProductOfferResponse> getList();
}
