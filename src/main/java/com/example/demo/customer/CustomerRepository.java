package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bariskantar
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {
    Optional<CustomerEntity> findByEmail(String email);
}
