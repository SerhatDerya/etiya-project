package com.etiya.catalogservice.service.requests;

import com.etiya.catalogservice.domain.entities.CharacteristicValue;
import com.etiya.catalogservice.domain.entities.Product;
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
public class CreateProductCharacteristicValueRequest {

    @NotNull(message = "Product id cannot be null")
    private UUID productId;
    @NotNull(message = "Characteristic Value id cannot be null")
    private UUID charValueId;
}
