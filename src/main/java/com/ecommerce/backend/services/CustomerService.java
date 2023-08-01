package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.services.models.CustomerFetch;

public interface CustomerService {

    void create(final Customer customer);
    void update(final Customer customer);
    Customer getCustomerDetails(final CustomerFetch customerFetchByFilter);
    void delete(final Customer customer);
}
