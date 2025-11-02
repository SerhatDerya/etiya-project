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
@Document(indexName = "customer-search")
public class CustomerSearch {


    private String id;
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


    public CustomerSearch(String id, String natId, String fatherName, String motherName, String gender, String dateOfBirth, String lastName, String middleName, String firstName) {
        this.id = id;
        this.natId = natId;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
    }
}
