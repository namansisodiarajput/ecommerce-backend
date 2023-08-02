package com.ecommerce.backend.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "customer_order")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerDetail;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id", nullable = false)
    private Product productDetails;

    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    @Column(name = "modifiedOn", nullable = false)
    private Date modifiedOn;
}
