package com.etiya.searchservice.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingAccountSearch {

    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String id;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String customerId;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String  addressId;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String statusId;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String typeId;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String accountNumber;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String accountName;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String typeName;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String statusName;
}
