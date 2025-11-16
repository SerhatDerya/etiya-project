package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.ProductSpecificationCharacteristic;
import com.etiya.catalogservice.repository.ProductSpecificationCharacteristicRepository;
import com.etiya.catalogservice.service.abstracts.ProductSpecificationCharacteristicService;
import com.etiya.catalogservice.service.mappings.ProductSpecificationCharacteristicMapper;
import com.etiya.catalogservice.service.requests.CreateProductSpecificationCharacteristicRequest;
import com.etiya.catalogservice.service.responses.productSpecificationCharacteristic.CreatedProductSpecificationCharacteristicResponse;
import com.etiya.catalogservice.service.responses.productSpecificationCharacteristic.GetListProductSpecificationCharacteristicResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSpecificationCharacteristicServiceImpl implements ProductSpecificationCharacteristicService {
    private final ProductSpecificationCharacteristicRepository productSpecificationCharacteristicRepository;

    public ProductSpecificationCharacteristicServiceImpl(ProductSpecificationCharacteristicRepository productSpecificationCharacteristicRepository) {
        this.productSpecificationCharacteristicRepository = productSpecificationCharacteristicRepository;
    }

    @Override
    public CreatedProductSpecificationCharacteristicResponse add(CreateProductSpecificationCharacteristicRequest request) {
        ProductSpecificationCharacteristic productSpecificationCharacteristic = ProductSpecificationCharacteristicMapper.INSTANCE.productSpecificationCharacteristicFromCreateProductSpecificationCharacteristicRequest(request);
        ProductSpecificationCharacteristic result = productSpecificationCharacteristicRepository.save(productSpecificationCharacteristic);
        CreatedProductSpecificationCharacteristicResponse response = ProductSpecificationCharacteristicMapper.INSTANCE.createdProductSpecificationCharacteristicResponseFromProductSpecificationCharacteristic(result);
        return response;
    }

    @Override
    public List<GetListProductSpecificationCharacteristicResponse> getList() {
        List<ProductSpecificationCharacteristic> productSpecificationCharacteristics = productSpecificationCharacteristicRepository.findAll();
        return ProductSpecificationCharacteristicMapper.INSTANCE.getListProductSpecificationCharacteristicResponseFromProductSpecificationCharacteristic(productSpecificationCharacteristics);
    }
}
