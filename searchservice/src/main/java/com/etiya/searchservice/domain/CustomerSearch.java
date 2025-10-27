package com.etiya.searchservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;



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



}
