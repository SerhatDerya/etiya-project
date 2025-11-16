package com.etiya.catalogservice.service.requests;

import com.etiya.catalogservice.domain.entities.Catalog;
import com.etiya.catalogservice.domain.entities.ProductOffer;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCatalogProductOfferRequest {

    @NotNull(message = "Catalog id cannot be null")
    private UUID catalogId;
    @NotNull(message = "Product Offer id cannot be null")
    private UUID productOfferId;
}
