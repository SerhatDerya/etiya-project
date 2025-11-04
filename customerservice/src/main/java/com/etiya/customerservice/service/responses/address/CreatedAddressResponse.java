package com.etiya.customerservice.service.responses.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedAddressResponse {

    private UUID id;
    private String title;
    private String street;
    private String houseNumber;
    private String description;
    private Boolean isDefault;
    private UUID customerId;
    private UUID cityId;
    private String cityName;
}
