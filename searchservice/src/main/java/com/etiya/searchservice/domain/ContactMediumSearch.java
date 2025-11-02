package com.etiya.searchservice.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumSearch {

    private String id;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
    private String customerId;
}
