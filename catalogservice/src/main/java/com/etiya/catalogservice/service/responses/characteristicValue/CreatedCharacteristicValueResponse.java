package com.etiya.catalogservice.service.responses.characteristicValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCharacteristicValueResponse {

    private UUID id;
    private String value;
    private UUID charId;
}
