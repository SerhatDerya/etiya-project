package com.etiya.common.events;

import java.time.LocalDate;

public record CreateCustomerEvent(String firstName, String middleName, String lastName, LocalDate dateOfBirth, String gender,
                                  String motherName, String fatherName, String nationalId) {
}

