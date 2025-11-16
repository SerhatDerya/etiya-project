package com.etiya.catalogservice.domain.entities;

import com.etiya.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "characteristic_values")
public class CharacteristicValue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "value")
    private String value;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "char_id",nullable = false)
    private Characteristic characteristic;

    @OneToMany(mappedBy = "characteristicValue",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ProductCharacteristicValue> productCharacteristicValues;
}
