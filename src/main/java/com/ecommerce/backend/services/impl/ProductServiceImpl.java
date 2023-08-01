package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.dao.product.ProductCreate;
import com.ecommerce.backend.dao.product.ProductDelete;
import com.ecommerce.backend.dao.product.ProductUpdate;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.repositories.ProductRepo;
import com.ecommerce.backend.services.ProductService;
import com.ecommerce.backend.dao.product.ProductFetch;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;
    @Override
    public void create(final ProductCreate productCreate) {

        final Product product = Product.builder()
                .productId(UUID.randomUUID().toString())
                .price(productCreate.getPrice())
                .name(productCreate.getName())
                .quantity(productCreate.getQuantity())
                .description(productCreate.getDescription())
                .createdOn(new Date())
                .modifiedOn(new Date())
                .build();

        productRepo.save(product);
    }

    @Override
    public void update(ProductUpdate productUpdate) {

        final Optional<Product> productOptional = productRepo.findById(productUpdate.getProductId());
        if(productOptional.isEmpty()) {
            throw  new IllegalArgumentException("Product not found.");
        }

        final Product product = productOptional.get();

        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        product.setDescription(productUpdate.getDescription());
        product.setQuantity(productUpdate.getQuantity());
        product.setModifiedOn(new Date());

        productRepo.save(product);
    }

    @Override
    public List<Product> get(ProductFetch productFetchByFilter) {
        return productRepo.findProductByDate(productFetchByFilter.getCreatedOn());
    }

    @Override
    public void delete(ProductDelete productDelete) {

        final Optional<Product> productOptional = productRepo.findById(productDelete.getProductId());
        if(productOptional.isEmpty()) {
            throw  new IllegalArgumentException("Product not found.");
        }

        productRepo.delete(productOptional.get());
    }
}
