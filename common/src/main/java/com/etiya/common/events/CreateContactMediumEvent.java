package com.etiya.common.events;

import java.util.UUID;

public record CreateContactMediumEvent(String id,
                                        String email,
                                        String homePhone,
                                        String mobilePhone,
                                        String fax,
                                        String customerId) {
}
