package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.services.impl.CustomerServiceImpl;
import com.ecommerce.backend.services.models.CustomerFetch;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ecommerce/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping
    public Customer getCustomerDetails(@RequestParam(required = true) final String email){
        final CustomerFetch customerFetch = CustomerFetch.builder().email(email).build();
        return customerService.getCustomerDetails(customerFetch);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(final Customer customer){
        customerService.create(customer);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateCustomer(final Customer customer){
        customerService.update(customer);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Object> deleteCustomer(final Customer customer){
        customerService.delete(customer);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
