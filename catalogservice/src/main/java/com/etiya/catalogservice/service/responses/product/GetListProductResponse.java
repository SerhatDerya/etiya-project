package com.etiya.catalogservice.service.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListProductResponse {

    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private UUID catalogId;
    private UUID specId;
}
