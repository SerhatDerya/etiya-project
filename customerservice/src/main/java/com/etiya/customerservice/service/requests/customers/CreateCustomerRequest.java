package com.etiya.customerservice.service.requests.customers;

import com.etiya.common.validations.MinAge;
import com.etiya.common.validations.NationalId;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @NotBlank(message = "firstName is required")
    @Size(min = 2, max = 20, message = "First Name should be between 2 and 50 character ")
    private String firstName;

    @Size(min = 2, max = 20, message = "Middle Name should be between 2 and 50 character ")
    private String middleName;

    @NotBlank(message = "lastName is required")
    @Size(min = 2, max = 20, message = "Last Name should be between 2 and 50 character ")
    private String lastName;

    @NotNull(message = "dateOfBirth is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @MinAge(value = 16,message = "Age must be higher or equal than 16")
    private LocalDate dateOfBirth;

    @NotBlank(message = "gender is required")
    private String gender;

    @Size(min = 2, max = 20, message = "Mother Name should be between 2 and 50 character ")
    private String motherName;

    @Size(min = 2, max = 20, message = "Father Name should be between 2 and 50 character ")
    private String fatherName;

    @NotBlank(message = "National Id is required ")
    @NationalId
    private String natId;
}
