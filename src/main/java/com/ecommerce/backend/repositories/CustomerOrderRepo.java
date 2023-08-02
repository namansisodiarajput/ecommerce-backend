package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.CustomerOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, String> {

    @Query(value = "SELECT * FROM customer_order WHERE customer_id = :customerId AND product_id = :productId",
            nativeQuery = true)
    Optional<CustomerOrder> findCustomerOrderByCustomerDetailAndProductDetails(
            @Param("customerId") String customerId, @Param("productId") String productId);

    @Query(value = "SELECT * FROM customer_order WHERE customer_id = :customerId", nativeQuery = true)
    List<CustomerOrder> findCustomerOrderByCustomerDetail(@Param("customerId") String customerId);
}
