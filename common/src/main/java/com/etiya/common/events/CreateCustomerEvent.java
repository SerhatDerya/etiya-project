package com.etiya.common.events;



public record CreateCustomerEvent(String id,
                                  String firstName,
                                  String middleName,
                                  String lastName,
                                  String dateOfBirth,
                                  String gender,
                                  String motherName,
                                  String fatherName,
                                  String natId) {
}

