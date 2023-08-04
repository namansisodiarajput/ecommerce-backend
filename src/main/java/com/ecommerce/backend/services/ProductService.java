package com.ecommerce.backend.services;

import com.ecommerce.backend.dao.product.ProductCreate;
import com.ecommerce.backend.dao.product.ProductDelete;
import com.ecommerce.backend.dao.product.ProductUpdate;
import com.ecommerce.backend.entities.Product;
import java.util.List;

public interface ProductService {

    void create(final ProductCreate productCreate);
    void update(final ProductUpdate productUpdate);
    List<Product> getAllProduct();

    Product getProductById(final String productId);
    void delete(final ProductDelete productDelete);
}
