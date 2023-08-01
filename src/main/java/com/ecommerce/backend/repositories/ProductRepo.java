package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

    @Query(value = "SELECT * FROM product WHERE :createdOn IS NULL or createdOn = :createdOn", nativeQuery = true)
    List<Product> findProductByDate(@Param("createdOn") Date createdOn);

}
