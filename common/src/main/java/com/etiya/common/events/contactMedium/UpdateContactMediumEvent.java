package com.etiya.common.events.contactMedium;

public record UpdateContactMediumEvent(String id,
                                       String email,
                                       String homePhone,
                                       String mobilePhone,
                                       String fax,
                                       String customerId) {
}
