package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.ProductCharacteristicValue;
import com.etiya.catalogservice.repository.ProductCharacteristicValueRepository;
import com.etiya.catalogservice.service.abstracts.ProductCharacteristicValueService;
import com.etiya.catalogservice.service.mappings.ProductCharacteristicValueMapper;
import com.etiya.catalogservice.service.requests.CreateProductCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.CreatedProductCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.productCharacteristicValue.GetListProductCharacteristicValueResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCharacteristicValueServiceImpl implements ProductCharacteristicValueService {
    private final ProductCharacteristicValueRepository productCharacteristicValueRepository;

    public ProductCharacteristicValueServiceImpl(ProductCharacteristicValueRepository productCharacteristicValueRepository) {
        this.productCharacteristicValueRepository = productCharacteristicValueRepository;
    }

    @Override
    public CreatedProductCharacteristicValueResponse add(CreateProductCharacteristicValueRequest request) {
        ProductCharacteristicValue productCharacteristicValue = ProductCharacteristicValueMapper.INSTANCE.productCharacteristicValueFromCreateProductCharacteristicValueRequest(request);
        ProductCharacteristicValue result = productCharacteristicValueRepository.save(productCharacteristicValue);
        CreatedProductCharacteristicValueResponse response = ProductCharacteristicValueMapper.INSTANCE.createdProductCharacteristicValueResponseFromProductCharacteristicValue(result);
        return response;
    }

    @Override
    public List<GetListProductCharacteristicValueResponse> getList() {
       List<ProductCharacteristicValue> productCharacteristicValues = productCharacteristicValueRepository.findAll();
       return ProductCharacteristicValueMapper.INSTANCE.getListProductCharacteristicValueResponseFromProductCharacteristicValue(productCharacteristicValues);
    }
}
