package com.ecommerce.backend.entities;
import jakarta.persistence.*;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    @Column(name = "modifiedOn", nullable = false)
    private Date modifiedOn;
}
