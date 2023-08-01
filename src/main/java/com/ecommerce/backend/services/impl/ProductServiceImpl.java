package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.repositories.ProductRepo;
import com.ecommerce.backend.services.ProductService;
import com.ecommerce.backend.services.models.ProductFetch;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;
    @Override
    public void create(Product product) {
        productRepo.save(product);
    }

    @Override
    public void update(Product product) {
        Optional<Product> existingProduct = productRepo.findById(product.getProductId());
        if(existingProduct.isEmpty()) {
            throw  new IllegalArgumentException("Product not found.");
        }
            productRepo.save(product);
        }

    @Override
    public List<Product> getProductDetails(ProductFetch productFetchByFilter) {
        return productRepo.findProductByDate(productFetchByFilter.getCreatedOn());
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }
}
