package com.etiya.searchservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "customer-search",createIndex = true)
public class CustomerSearch {


    private String id;
    private String customerNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String motherName;
    private String fatherName;
    private String natId;

    @Field(type = FieldType.Nested)
    private List<ContactMediumSearch> contactMediums= new ArrayList<>();
    @Field(type = FieldType.Nested)
    private List<AddressSearch> addressSearches= new ArrayList<>();

    public CustomerSearch(String id,String customerNumber, String firstName, String middleName, String lastName, String dateOfBirth, String gender, String motherName, String fatherName, String natId) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.natId = natId;
    }
}
