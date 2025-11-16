package com.etiya.catalogservice.domain.entities;

import com.etiya.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_specification_characteristics")
public class ProductSpecificationCharacteristic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "is_configurable")
    private Boolean isConfigurable;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spec_id", nullable = false)
    private ProductSpecification productSpecification;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "char_id",nullable = false)
    private Characteristic characteristic;
}
