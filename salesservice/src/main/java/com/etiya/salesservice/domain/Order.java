package com.etiya.salesservice.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "orders")
public class Order {
    @MongoId
    @Field(name = "id")
    private UUID id;

    @Field(name = "billingAccountId")
    private UUID billingAccountId;

    @Field(name = "totalPrice")
    private Double totalPrice;

    //TODO: Müşteri bilgileri => FirstName,LastName,Email

    private List<OrderItem> orderItems;
}
