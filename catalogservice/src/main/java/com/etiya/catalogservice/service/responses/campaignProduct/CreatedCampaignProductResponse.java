package com.etiya.catalogservice.service.responses.campaignProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCampaignProductResponse {
    private UUID id;
    private UUID productId;
    private UUID campaignId;
}
