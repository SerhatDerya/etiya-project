package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.Product;
import com.etiya.catalogservice.repository.ProductRepository;
import com.etiya.catalogservice.service.abstracts.ProductService;
import com.etiya.catalogservice.service.mappings.ProductMapper;
import com.etiya.catalogservice.service.requests.CreateProductRequest;
import com.etiya.catalogservice.service.responses.product.CreatedProductResponse;
import com.etiya.catalogservice.service.responses.product.GetListProductResponse;
import com.etiya.catalogservice.service.rules.ProductBusinessRules;
import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.responses.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;

    public ProductServiceImpl(ProductRepository productRepository, ProductBusinessRules productBusinessRules) {
        this.productRepository = productRepository;
        this.productBusinessRules = productBusinessRules;
    }

    @Override
    public CreatedProductResponse add(CreateProductRequest request) {
        Product product = ProductMapper.INSTANCE.productFromCreateProductRequest(request);
        Product result = productRepository.save(product);
        CreatedProductResponse response = ProductMapper.INSTANCE.createdProductResponseFromProduct(result);
        return response;
    }

    @Override
    public List<GetListProductResponse> getList() {
        List<Product> products = productRepository.findAll();
        return ProductMapper.INSTANCE.getListProductResponseFromProduct(products);
    }

    @Override
    public CreatedProductResponse getById(UUID id) {
        Product product = productBusinessRules.getProductIfExists(id);
        return ProductMapper.INSTANCE.createdProductResponseFromProduct(product);
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        Product product = productBusinessRules.getProductIfExists(id);
        return ProductMapper.INSTANCE.productResponseFromProduct(product);
    }

}
