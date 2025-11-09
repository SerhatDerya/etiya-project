package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
