package com.etiya.catalogservice.repository;

import com.etiya.catalogservice.domain.entities.ProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductOfferRepository extends JpaRepository<ProductOffer, UUID> {

    @Query("""
            SELECT po
            FROM ProductOffer po
            JOIN po.product p
            JOIN p.catalog c
            WHERE c.id = :id
            """)
    List<ProductOffer> findByCatalogId(UUID id);
}
