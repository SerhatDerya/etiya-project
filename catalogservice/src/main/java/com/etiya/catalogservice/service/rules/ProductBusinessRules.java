package com.etiya.catalogservice.service.rules;

import com.etiya.catalogservice.domain.entities.Product;
import com.etiya.catalogservice.repository.ProductRepository;
import com.etiya.catalogservice.service.messages.Messages;
import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductBusinessRules {
    private final ProductRepository productRepository;
    private final LocalizationService localizationService;

    public ProductBusinessRules(ProductRepository productRepository, LocalizationService localizationService) {
        this.productRepository = productRepository;
        this.localizationService = localizationService;
    }

    public Product getProductIfExists(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new BusinessException(localizationService.getMessage(Messages.ProductNotFound)));
    }
}
