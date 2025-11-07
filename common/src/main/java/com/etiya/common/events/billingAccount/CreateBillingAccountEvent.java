package com.etiya.common.events.billingAccount;

public record CreateBillingAccountEvent( String id,
                                         String customerId,
                                         String addressId,
                                         String statusId,
                                         String typeId,
                                         String accountNumber,
                                         String accountName,
                                         String typeName,
                                         String statusName) {
}
