package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.ProductService;
import com.ecommerce.backend.services.models.ProductFetch;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//@RestController
//@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping
    public void createProduct(final Product product){
        productService.create(product);
    }

    @PutMapping
    public void updateProduct(final Product product){
        productService.update(product);
    }
    @GetMapping
    public List<Product> getProductDetails(@RequestParam(name= "date", required = false) @Nullable Date createdDate){
        final ProductFetch productFetch = ProductFetch.builder().createdOn(createdDate).build();
        return productService.getProductDetails(productFetch);
    }

    @DeleteMapping
    public void deleteProduct(final Product product){
        productService.delete(product);
    }

}
