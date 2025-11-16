package com.etiya.catalogservice.service.responses.catalogProductOffer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCatalogProductOfferResponse {

    private UUID id;
    private UUID catalogId;
    private UUID productOfferId;
}
