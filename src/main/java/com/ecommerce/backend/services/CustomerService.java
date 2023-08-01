package com.ecommerce.backend.services;

import com.ecommerce.backend.dao.customer.CustomerCreate;
import com.ecommerce.backend.dao.customer.CustomerDelete;
import com.ecommerce.backend.dao.customer.CustomerUpdate;
import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.dao.customer.CustomerFetch;

public interface CustomerService {

    void create(final CustomerCreate customerCreate);
    void update(final CustomerUpdate customerUpdate);
    Customer get(final CustomerFetch customerFetch);
    void delete(final CustomerDelete customerDelete);
}
