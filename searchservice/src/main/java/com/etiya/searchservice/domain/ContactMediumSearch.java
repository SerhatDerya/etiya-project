package com.etiya.searchservice.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldElementType;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumSearch {

    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String id;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String email;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String homePhone;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String mobilePhone;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String fax;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String customerId;
}
