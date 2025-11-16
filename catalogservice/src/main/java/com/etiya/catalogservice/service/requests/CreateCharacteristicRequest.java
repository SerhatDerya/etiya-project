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
public class CreateCharacteristicRequest {


    private String description;
    private String dataType;
    private String unitOfMeasurement;
}
