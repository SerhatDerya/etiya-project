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
public class CreatedBillingAccountResponse {

    private UUID id;
    private UUID customerId;
    private UUID  addressId;
    private Integer statusId;
    private Integer typeId;
    private String accountNumber;
    private String accountName;
    private String typeName;
    private String statusName;


}
