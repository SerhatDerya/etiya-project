package com.etiya.customerservice.service.requests.billingAccount;

import com.etiya.common.validations.Status;
import com.etiya.common.validations.Type;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillingAccountRequest {

    @NotNull(message = "Customer Id cannot be null")
    private UUID customerId;
    @NotNull(message = "Address Id cannot be null")
    private UUID  addressId;
    @NotBlank(message = "Account number cannot be empty")
    private String accountName;
    @NotBlank(message = "Type cannot be empty")
    @Type
    private String type;
    @NotBlank(message = "Status cannot be empty")
    @Status
    private String status;
}
