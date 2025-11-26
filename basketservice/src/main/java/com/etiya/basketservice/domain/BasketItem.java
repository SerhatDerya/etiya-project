package com.etiya.basketservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BasketItem {

    private String id;
    private UUID productId;
    private String productName;
    private Double price;

    public BasketItem(){
        this.id = UUID.randomUUID().toString();
    }
}
