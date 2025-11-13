package com.etiya.customerservice.service.requests.billingAccount;

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
public class UpdateBillingAccountRequest {
    @NotNull(message = "Customer Id cannot be null")
    private UUID customerId;
    @NotNull(message = "Address Id cannot be null")
    private UUID  addressId;
    @NotBlank(message = "Account number cannot be empty")
    private String accountName;

}
