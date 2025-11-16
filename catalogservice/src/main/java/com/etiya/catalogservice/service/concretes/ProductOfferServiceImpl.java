package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.ProductOffer;
import com.etiya.catalogservice.repository.ProductOfferRepository;
import com.etiya.catalogservice.service.abstracts.ProductOfferService;
import com.etiya.catalogservice.service.mappings.ProductOfferMapper;
import com.etiya.catalogservice.service.requests.CreateProductOfferRequest;
import com.etiya.catalogservice.service.responses.productOffer.CreatedProductOfferResponse;
import com.etiya.catalogservice.service.responses.productOffer.GetListProductOfferResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOfferServiceImpl implements ProductOfferService {
    private final ProductOfferRepository productOfferRepository;

    public ProductOfferServiceImpl(ProductOfferRepository productOfferRepository) {
        this.productOfferRepository = productOfferRepository;
    }

    @Override
    public CreatedProductOfferResponse add(CreateProductOfferRequest request) {
        ProductOffer productOffer = ProductOfferMapper.INSTANCE.productOfferFromCreateProductOfferRequest(request);
        ProductOffer result = productOfferRepository.save(productOffer);
        CreatedProductOfferResponse response = ProductOfferMapper.INSTANCE.createdProductOfferResponseFromProductOffer(result);
        return response;
    }

    @Override
    public List<GetListProductOfferResponse> getList() {
        List<ProductOffer> productOffers = productOfferRepository.findAll();
        return ProductOfferMapper.INSTANCE.getListProductOfferResponseFromProductOffer(productOffers);
    }
}
