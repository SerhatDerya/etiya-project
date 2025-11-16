package com.etiya.catalogservice.service.responses.productSpecification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedProductSpecificationResponse {

    private UUID id;
    private String description;
    private String lifecycleStatus;
    private String productType;
}
