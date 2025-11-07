package com.etiya.common.events;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

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
