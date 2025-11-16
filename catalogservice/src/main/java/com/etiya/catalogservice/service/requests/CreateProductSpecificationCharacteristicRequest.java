package com.etiya.catalogservice.service.requests;

import com.etiya.catalogservice.domain.entities.Characteristic;
import com.etiya.catalogservice.domain.entities.ProductSpecification;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CreateProductSpecificationCharacteristicRequest {


    private Boolean isConfigurable;
    @NotNull(message = "Product Specification id cannot be null")
    private UUID specId;
    @NotNull(message = "Characteristic id cannot be null")
    private UUID charId;
}
