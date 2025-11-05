package com.etiya.customerservice.service.responses.billingAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListBillingAccountResponse {

    private UUID id;
    private UUID customerId;
    private UUID  addressId;
    private String accountNumber;
    private String accountName;
    private String type;
    private String status;
}
