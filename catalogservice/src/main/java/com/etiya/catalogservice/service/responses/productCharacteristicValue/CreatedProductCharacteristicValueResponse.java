package com.etiya.catalogservice.service.responses.productCharacteristicValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedProductCharacteristicValueResponse {

    private UUID id;
    private UUID productId;
    private UUID charValueId;
}
