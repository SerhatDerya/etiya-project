package com.etiya.catalogservice.service.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 character ")
    private String name;
    private Double price;
    private Integer stock;
    @NotNull(message = "Catalog id cannot be null")
    private UUID catalogId;
    @NotNull(message = "Product Specification id cannot be null")
    private UUID specId;

}
