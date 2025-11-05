package com.etiya.customerservice.domain.entities;

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
@Table(name = "billing_accounts")
public class BillingAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "account_name", nullable = false)
    private String accountName;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "status", nullable = false)
    private String status;


    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "customer_id", nullable = false)
    private  Customer customer;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "address_id", nullable = false)
    private  Address address;

    @PrePersist
    public void generateAccountNumber()
    {
        String prefix = "BACC-";
        String year = String.valueOf(java.time.Year.now().getValue());
        String randomPart = String.format("%04d", new java.util.Random().nextInt(10000));
        this.accountNumber = prefix + year + '-' + randomPart;
    }

}
