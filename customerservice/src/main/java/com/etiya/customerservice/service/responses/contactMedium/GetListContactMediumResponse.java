package com.etiya.customerservice.service.responses.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListContactMediumResponse {

    private UUID id;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
    private UUID customerId;
}
