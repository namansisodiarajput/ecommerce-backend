package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.dao.product.ProductCreate;
import com.ecommerce.backend.dao.product.ProductDelete;
import com.ecommerce.backend.dao.product.ProductUpdate;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.repositories.ProductRepo;
import com.ecommerce.backend.services.MatricesPublishesService;
import com.ecommerce.backend.services.ProductService;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepo productRepo;
    @Autowired
    private final MatricesPublishesService matricesPublishesService;
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

        matricesPublishesService.productCreated(product);
    }

    @Override
    public void update(final ProductUpdate productUpdate) {

        final Product product = getProductById(productUpdate.getProductId());

        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        product.setDescription(productUpdate.getDescription());
        product.setQuantity(productUpdate.getQuantity());
        product.setModifiedOn(new Date());

        productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public void delete(final ProductDelete productDelete) {

        final Product product = getProductById(productDelete.getProductId());
        productRepo.delete(product);
    }

    @Override
    public Product getProductById(final String productId) {
        final Optional<Product> productOptional = productRepo.findById(productId);
        if(productOptional.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("Product not found for the product id %s", productId));
        }
        return productOptional.get();
    }
}
