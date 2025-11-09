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
@Table(name = "statuses")
@SQLRestriction("deleted_date IS NULL")
public class Status extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "status",
                fetch = FetchType.LAZY)
    private List<BillingAccount> billingAccounts;


}



