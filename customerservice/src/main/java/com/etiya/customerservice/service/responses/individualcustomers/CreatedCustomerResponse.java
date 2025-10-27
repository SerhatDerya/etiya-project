package com.etiya.customerservice.service.responses.individualcustomers;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreatedCustomerResponse {
    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;

    private String motherName;

    private String fatherName;

    private String natId;
}
