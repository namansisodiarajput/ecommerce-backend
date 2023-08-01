package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.dao.customer.CustomerCreate;
import com.ecommerce.backend.dao.customer.CustomerDelete;
import com.ecommerce.backend.dao.customer.CustomerUpdate;
import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.repositories.CustomerRepo;
import com.ecommerce.backend.services.CustomerService;
import com.ecommerce.backend.dao.customer.CustomerFetch;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public void create(CustomerCreate customerCreate) {

        final Customer customer = Customer.builder()
                .customerId(UUID.randomUUID().toString())
                .email(customerCreate.getEmail())
                .address(customerCreate.getAddress())
                .age(customerCreate.getAge())
                .name(customerCreate.getName())
                .createdOn(new Date())
                .modifiedOn(new Date())
                .build();

        customerRepo.save(customer);
    }

    @Override
    public void update(CustomerUpdate customerUpdate) {
        final Optional<Customer> optionalCustomer = customerRepo.findByEmail(customerUpdate.getEmail());
        if(optionalCustomer.isEmpty()){
            throw new IllegalArgumentException("Customer not found.");
        }

        final Customer customer = optionalCustomer.get();

        customer.setName(customerUpdate.getName());
        customer.setAge(customerUpdate.getAge());
        customer.setAddress(customerUpdate.getAddress());
        customer.setModifiedOn(new Date());

        customerRepo.save(customer);
    }

    @Override
    public Customer get(CustomerFetch customerFetchByFilter) {
        final Optional<Customer> customer = customerRepo.findByEmail(customerFetchByFilter.getEmail());
        if(customer.isEmpty()){
            throw new IllegalArgumentException("Customer not found.");
        }
        return customer.get();
    }

    @Override
    public void delete(CustomerDelete customerDelete) {

        final Optional<Customer> customer = customerRepo.findByEmail(customerDelete.getEmail());
        if(customer.isEmpty()){
            throw new IllegalArgumentException("Customer not found.");
        }

        customerRepo.delete(customer.get());
    }
}
