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
public class AddressSearch {
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String id;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String title;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String street;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String houseNumber;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String description;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private Boolean isDefault;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String customerId;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String cityId;
    @Field(type = FieldType.Keyword, index = true, docValues = true)
    private String cityName;
}
