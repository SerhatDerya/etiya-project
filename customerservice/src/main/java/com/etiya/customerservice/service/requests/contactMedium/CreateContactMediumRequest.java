package com.etiya.customerservice.service.requests.contactMedium;


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
public class CreateContactMediumRequest {


    @NotBlank(message = "Email Required")
    private String email;

    @Size(min = 8, max = 20)
    private String homePhone;

    @NotBlank(message = "Mobile Phone Required")
    @Size(min = 8, max = 20)
    private String mobilePhone;

    @Size(min = 8, max = 20)
    private String fax;

    @NotNull(message = "Customer id cannot be null")
    private UUID customerId;
}
