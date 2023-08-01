package com.ecommerce.backend.controllers;

import com.ecommerce.backend.dao.customer.CustomerCreate;
import com.ecommerce.backend.dao.customer.CustomerDelete;
import com.ecommerce.backend.dao.customer.CustomerUpdate;
import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.services.CustomerService;
import com.ecommerce.backend.dao.customer.CustomerFetch;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce-backend/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Create new customer")
    public void createCustomer(final CustomerCreate customerCreateRequest){
        customerService.create(customerCreateRequest);
    }

    @PutMapping
    @Operation(summary = "Update existing customer")
    public void updateCustomer(final CustomerUpdate customerUpdate){
        customerService.update(customerUpdate);
    }

    @GetMapping
    @Operation(summary = "Get existing customer by email id")
    public Customer getCustomerDetails(@RequestParam(required = true) final String email){
        final CustomerFetch customerFetch = CustomerFetch.builder().email(email).build();
        return customerService.get(customerFetch);
    }

    @DeleteMapping
    @Operation(summary = "Delete existing customer by email id")
    public void deleteCustomer(final CustomerDelete customerDelete){
        customerService.delete(customerDelete);
    }
}
