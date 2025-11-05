package com.etiya.customerservice.service.responses.billingAccount;


import com.etiya.common.validations.Status;
import com.etiya.common.validations.Type;
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
public class CreatedBillingAccountResponse {

    private UUID id;
    private UUID customerId;
    private UUID  addressId;
    private String accountNumber;
    private String accountName;
    private String type;
    private String status;


}
