package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    Customer customerDetail;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    Product productDetails;

    @Column(name = "status")
    String status;

    @Column(name = "createdOn")
    Date createdOn;

    @Column(name = "modifiedOn")
    Date modifiedOn;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerDetail=" + customerDetail +
                ", productDetails=" + productDetails +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
