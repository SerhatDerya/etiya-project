package com.etiya.catalogservice.service.requests;

import com.etiya.catalogservice.domain.entities.Campaign;
import com.etiya.catalogservice.domain.entities.Product;
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
public class CreateCampaignProductRequest {

    @NotNull(message = "Product id cannot be null")
    private UUID productId;
    @NotNull(message = "Campaign id cannot be null")
    private UUID campaignId;
}
