package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, String> {

}
