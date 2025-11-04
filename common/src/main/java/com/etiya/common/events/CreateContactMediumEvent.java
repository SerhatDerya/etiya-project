package com.etiya.common.events;



public record CreateContactMediumEvent(String id,
                                        String email,
                                        String homePhone,
                                        String mobilePhone,
                                        String fax,
                                        String customerId) {
}
