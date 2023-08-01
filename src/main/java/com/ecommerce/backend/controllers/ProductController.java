package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.impl.ProductServiceImpl;
import com.ecommerce.backend.services.models.ProductFetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController("/ecommerce/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping
    public void createProduct(final Product product){
        productService.create(product);
    }
    @GetMapping
    public List<Product> getProductDetails(@RequestParam(name= "date") final Date createdDate){
        final ProductFetch productFetch = ProductFetch.builder().createdOn(createdDate).build();
        return productService.getProductDetails(productFetch);
    }
    @PutMapping
    public void updateProduct(final Product product){
        productService.update(product);
    }
    @DeleteMapping
    public void deleteProduct(final Product product){
        productService.delete(product);
    }

}
