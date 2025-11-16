package com.etiya.catalogservice.service.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductSpecificationRequest {

    private String description;
    private String lifecycleStatus;
    private String productType;
}
