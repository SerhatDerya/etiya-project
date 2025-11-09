package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.IndividualCustomer;
import org.springframework.stereotype.Repository;



@Repository
public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer> {
    boolean existsByNatId(String identityNumber);
    IndividualCustomer findByNatId(String natId);

}
