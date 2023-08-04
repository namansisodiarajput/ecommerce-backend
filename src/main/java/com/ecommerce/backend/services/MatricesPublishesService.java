package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.entities.Product;

public interface MatricesPublishesService {

    void customerCreated(final Customer customer);
    void productCreated(final Product product);

}
