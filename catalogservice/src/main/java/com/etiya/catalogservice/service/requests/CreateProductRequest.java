package com.etiya.catalogservice.service.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    private String name;
    private Double price;
    private Integer stock;
    @NotNull(message = "Catalog id cannot be null")
    private UUID catalogId;
    @NotNull(message = "Product Specification id cannot be null")
    private UUID specId;

}
