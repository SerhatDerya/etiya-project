package com.etiya.salesservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Getter
@Setter
public class OrderItem {

    @Field(name = "id")
    private UUID id;

    @Field(name = "productId")
    private UUID productId;

    @Field(name = "productName")
    private String productName;

    @Field(name = "price")
    private Double price;
}
