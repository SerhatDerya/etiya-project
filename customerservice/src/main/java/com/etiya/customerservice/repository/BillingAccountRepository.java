package com.etiya.customerservice.repository;


import com.etiya.customerservice.domain.entities.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BillingAccountRepository extends JpaRepository<BillingAccount, UUID> {

    @Query("SELECT a FROM BillingAccount a " +
            "JOIN FETCH a.status " +
            "JOIN FETCH a.type " +
            "WHERE a.id = :id")
    Optional<BillingAccount> findByIdWithAccount(@Param("id") UUID id);



}
