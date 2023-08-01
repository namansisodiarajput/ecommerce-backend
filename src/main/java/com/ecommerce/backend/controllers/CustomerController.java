package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.services.CustomerService;
import com.ecommerce.backend.services.models.CustomerFetch;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Create new customer")
    public ResponseEntity<Object> createCustomer(final Customer customer){
        customerService.create(customer);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update existing customer")
    public ResponseEntity<Object> updateCustomer(final Customer customer){
        customerService.update(customer);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get existing customer by email id")
    public Customer getCustomerDetails(@RequestParam(required = true) final String email){
        final CustomerFetch customerFetch = CustomerFetch.builder().email(email).build();
        return customerService.getCustomerDetails(customerFetch);
    }

    @DeleteMapping
    @Operation(summary = "Delete existing customer")
    public ResponseEntity<Object> deleteCustomer(final Customer customer){
        customerService.delete(customer);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
