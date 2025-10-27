package com.etiya.customerservice.domain.entities;

import com.etiya.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "dateOfBirth",nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "natId",nullable = false,unique = true)
    private String natId;

}

