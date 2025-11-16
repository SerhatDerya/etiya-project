package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.ProductSpecification;
import com.etiya.catalogservice.repository.ProductOfferRepository;
import com.etiya.catalogservice.repository.ProductSpecificationRepository;
import com.etiya.catalogservice.service.abstracts.ProductSpecificationService;
import com.etiya.catalogservice.service.mappings.ProductSpecificationMapper;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationRequest;
import com.etiya.catalogservice.service.responses.productSpecification.CreatedProductSpecificationResponse;
import com.etiya.catalogservice.service.responses.productSpecification.GetListProductSpecificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {
    private final ProductSpecificationRepository productSpecificationRepository;

    public ProductSpecificationServiceImpl(ProductSpecificationRepository productSpecificationRepository) {
        this.productSpecificationRepository = productSpecificationRepository;
    }

    @Override
    public CreatedProductSpecificationResponse add(CreateProductSpecificationRequest request) {
        ProductSpecification  productSpecification = ProductSpecificationMapper.INSTANCE.productSpecificationFromCreateProductSpecificationRequest(request);
        ProductSpecification result = productSpecificationRepository.save(productSpecification);
        CreatedProductSpecificationResponse response = ProductSpecificationMapper.INSTANCE.createdProductSpecificationResponseFromProductSpecification(result);
        return response;
    }

    @Override
    public List<GetListProductSpecificationResponse> getList() {
        List<ProductSpecification> productSpecifications = productSpecificationRepository.findAll();
        return ProductSpecificationMapper.INSTANCE.getListProductSpecificationResponseFromProductSpecification(productSpecifications);
    }
}
