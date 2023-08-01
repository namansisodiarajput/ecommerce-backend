package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.models.ProductFetch;
import java.util.List;

public interface ProductService {

    void create(final Product product);
    void update(final Product product);
    List<Product> getProductDetails(final ProductFetch productFetchByFilter);
    void delete(final Product product);
}
