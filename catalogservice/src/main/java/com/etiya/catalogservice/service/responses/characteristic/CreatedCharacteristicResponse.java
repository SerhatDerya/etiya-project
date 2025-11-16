package com.etiya.catalogservice.service.responses.characteristic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCharacteristicResponse {

    private UUID id;
    private String description;
    private String dataType;
    private String unitOfMeasurement;
}
