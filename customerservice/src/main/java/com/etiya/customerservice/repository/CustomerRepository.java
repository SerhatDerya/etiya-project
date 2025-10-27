package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsById(int id);
    boolean existsByNatId(String identityNumber);
}
