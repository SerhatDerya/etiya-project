package com.etiya.common.events.customer;

public record UpdateCustomerEvent(String id,
                                  String customerNumber,
                                  String firstName,
                                  String middleName,
                                  String lastName,
                                  String dateOfBirth,
                                  String gender,
                                  String motherName,
                                  String fatherName,
                                  String natId) {
}
