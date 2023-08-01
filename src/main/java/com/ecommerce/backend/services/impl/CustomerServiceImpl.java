package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.repositories.CustomerRepo;
import com.ecommerce.backend.services.CustomerService;
import com.ecommerce.backend.services.models.CustomerFetch;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        Optional<Customer> existingCustomer = customerRepo.findByEmail(customer.getEmail());
        if(existingCustomer.isEmpty()){
            throw new IllegalArgumentException("Customer not found.");
        }
        customerRepo.save(existingCustomer.get());

    }

    @Override
    public Customer getCustomerDetails(CustomerFetch customerFetchByFilter) {
        Optional<Customer> customer = customerRepo.findByEmail(customerFetchByFilter.getEmail());
        if(customer.isEmpty()){
            throw new IllegalArgumentException("Customer not found.");
        }
        return customer.get();
    }

    @Override
    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }
}
