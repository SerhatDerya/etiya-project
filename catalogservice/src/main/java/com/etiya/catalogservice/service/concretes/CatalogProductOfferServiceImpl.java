package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.CatalogProductOffer;
import com.etiya.catalogservice.repository.CatalogProductOfferRepository;
import com.etiya.catalogservice.service.abstracts.CatalogProductOfferService;
import com.etiya.catalogservice.service.mappings.CatalogProductOfferMapper;
import com.etiya.catalogservice.service.requests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.service.responses.catalogProductOffer.CreatedCatalogProductOfferResponse;
import com.etiya.catalogservice.service.responses.catalogProductOffer.GetListCatalogProductOfferResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogProductOfferServiceImpl implements CatalogProductOfferService {
    private final CatalogProductOfferRepository catalogProductOfferRepository;

    public CatalogProductOfferServiceImpl(CatalogProductOfferRepository catalogProductOfferRepository) {
        this.catalogProductOfferRepository = catalogProductOfferRepository;
    }

    @Override
    public CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest request) {
        CatalogProductOffer catalogProductOffer = CatalogProductOfferMapper.INSTANCE.catalogProductOfferFromCreateCatalogProductOfferRequest(request);
        CatalogProductOffer result = catalogProductOfferRepository.save(catalogProductOffer);
        CreatedCatalogProductOfferResponse response = CatalogProductOfferMapper.INSTANCE.createdCatalogProductOfferResponseFromCatalogProductOffer(result);
        return response;
    }

    @Override
    public List<GetListCatalogProductOfferResponse> getList() {
        List<CatalogProductOffer> catalogProductOffers = catalogProductOfferRepository.findAll();
        return CatalogProductOfferMapper.INSTANCE.getListCatalogProductOfferResponseFromCatalogProductOffer(catalogProductOffers);
    }
}
