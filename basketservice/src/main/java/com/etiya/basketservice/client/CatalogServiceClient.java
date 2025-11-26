package com.etiya.basketservice.client;

import com.etiya.common.responses.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@FeignClient(name = "catalogservice")
public interface CatalogServiceClient{

    @GetMapping("/api/products/response/{id}")
    ProductResponse getProductById(@PathVariable UUID id);


}
