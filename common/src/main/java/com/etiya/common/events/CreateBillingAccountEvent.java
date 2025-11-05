package com.etiya.common.events;

import java.util.UUID;

public record CreateBillingAccountEvent( String id,
                                         String customerId,
                                         String  addressId,
                                         String accountNumber,
                                         String accountName,
                                         String type,
                                         String status) {
}
