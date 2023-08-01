package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.services.models.CustomerFetch;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    void create(final Customer customer);
    void update(final Customer customer);
    Customer getCustomerDetails(final CustomerFetch customerFetchByFilter);
    void delete(final Customer customer);
}
