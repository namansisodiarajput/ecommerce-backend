package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
}
