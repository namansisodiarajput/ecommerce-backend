package com.ecommerce.backend.entities;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    @Column(name = "modifiedOn", nullable = false)
    private Date modifiedOn;
}
