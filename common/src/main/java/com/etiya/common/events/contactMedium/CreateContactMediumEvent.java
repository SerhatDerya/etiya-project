package com.etiya.common.events.contactMedium;



public record CreateContactMediumEvent(String id,
                                        String email,
                                        String homePhone,
                                        String mobilePhone,
                                        String fax,
                                        String customerId) {
}
