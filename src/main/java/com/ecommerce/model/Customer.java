package com.ecommerce.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer customerId;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "age")
    Integer age;

    @Column(name = "address")
    String address;

    @Column(name = "isActive")
    Boolean isActive;

    @Column(name = "createdOn")
    Date createdOn;

    @Column(name = "modifiedOn")
    Date modifiedOn;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", isActive=" + isActive +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
