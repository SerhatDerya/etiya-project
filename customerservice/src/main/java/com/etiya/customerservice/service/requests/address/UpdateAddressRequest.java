package com.etiya.customerservice.service.requests.address;

import jakarta.validation.constraints.NotBlank;
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
public class UpdateAddressRequest {
    @NotBlank(message = "Title Required")
    private String title;
    @NotBlank(message = "Street Required")
    private String street;
    @NotBlank(message = "House Number Required")
    private String houseNumber;
    @NotBlank(message = "Description Required")
    private String description;
    private Boolean isDefault;
    @NotNull(message = "Customer id cannot be null")
    private UUID customerId;
    @NotNull(message = "City id cannot be null")
    private Integer cityId;
}
