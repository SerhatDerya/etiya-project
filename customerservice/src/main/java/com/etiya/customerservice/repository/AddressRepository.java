package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    @Query("SELECT a FROM Address a " +
            "JOIN FETCH a.city " +
            "WHERE a.id = :id")
    Optional<Address> findByIdWithCity(@Param("id") UUID id);
}
