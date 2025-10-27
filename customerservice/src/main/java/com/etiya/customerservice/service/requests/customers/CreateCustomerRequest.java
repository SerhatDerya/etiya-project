package com.etiya.customerservice.service.requests.customers;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCustomerRequest {
    @NotBlank(message = "firstName is required")
    @Column(name = "firstName",nullable = false,length = 20)
    @Size(min = 2, max = 20, message = "İsim 2 ile 20 karakter arasında olmalıdır.")
    private String firstName;

    @Column(name = "middleName")
    @Size(min = 2, max = 20, message = "İsim 2 ile 20 karakter arasında olmalıdır.")
    private String middleName;

    @NotBlank(message = "lastName is required")
    @Column(name = "lastName", nullable = false)
    @Size(min = 2, max = 20, message = "Soyisim 2 ile 20 karakter arasında olmalıdır.")
    private String lastName;

    @NotNull(message = "dateOfBirth is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "gender is required")
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "motherName")
    @Size(min = 2, max = 20, message = "Anne ismi 2 ile 20 karakter arasında olmalıdır.")
    private String motherName;

    @Column(name = "fatherName")
    @Size(min = 2, max = 20, message = "Baba ismi 2 ile 20 karakter arasında olmalıdır.")
    private String fatherName;

    @NotBlank(message = "T.C. kimlik numarası gereklidir")
    @Pattern(regexp = "^[0-9]{11}$", message = "T.C. Kimlik numarası 11 haneli ve sadece rakamlardan oluşmalıdır")
    @Column(name = "natId", nullable = false, unique = true, length = 11)
    private String natId;
}
