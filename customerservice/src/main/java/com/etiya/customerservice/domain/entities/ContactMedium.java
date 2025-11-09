package com.etiya.customerservice.domain.entities;

import com.etiya.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact_mediums")
@SQLRestriction("deleted_date IS NULL")
public class ContactMedium extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name ="email" ,nullable = false)
    private String email;

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "mobilePhone",nullable = false)
    private String mobilePhone;

    @Column(name = "fax")
    private String fax;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "customer_id", nullable = false)
    private Customer customer;
}
