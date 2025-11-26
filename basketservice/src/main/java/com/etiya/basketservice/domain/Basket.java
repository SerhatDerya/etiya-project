package com.etiya.basketservice.domain;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Basket implements Serializable {

    private String id;
    private UUID billingAccountId;
    private Double totalPrice;
    private List<BasketItem> basketItems;

    public Basket(){
        this.id= UUID.randomUUID().toString();
        this.basketItems = new ArrayList<>();
    }
}
