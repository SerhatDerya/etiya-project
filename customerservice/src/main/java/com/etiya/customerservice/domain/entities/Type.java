package com.etiya.customerservice.domain.entities;

import com.etiya.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "types")
@SQLRestriction("deleted_date IS NULL")
public class Type extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "type",
            fetch = FetchType.LAZY)
    public List<BillingAccount> billingAccounts;
}
