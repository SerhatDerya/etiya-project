package com.etiya.catalogservice.service.responses.catalog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCatalogResponse {

    private UUID id;
    private String name;
    private UUID parentId;
}
