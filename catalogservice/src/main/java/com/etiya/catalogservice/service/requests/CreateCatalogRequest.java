package com.etiya.catalogservice.service.requests;

import com.etiya.catalogservice.domain.entities.Catalog;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCatalogRequest {

    private String name;
    private UUID parentId;
}
