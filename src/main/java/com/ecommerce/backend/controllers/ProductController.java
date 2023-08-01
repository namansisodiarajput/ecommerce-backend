package com.ecommerce.backend.controllers;

import com.ecommerce.backend.dao.product.ProductCreate;
import com.ecommerce.backend.dao.product.ProductDelete;
import com.ecommerce.backend.dao.product.ProductUpdate;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.ProductService;
import com.ecommerce.backend.dao.product.ProductFetch;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ecommerce-backend/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping
    @Operation(summary = "Create new product")
    public void createProduct(final ProductCreate productCreate){
        productService.create(productCreate);
    }

    @PutMapping
    @Operation(summary = "Update existing product")
    public void updateProduct(final ProductUpdate productUpdate){
        productService.update(productUpdate);
    }
    @GetMapping
    @Operation(summary = "Get product details filtered by date")
    public List<Product> getProductDetails(@RequestParam(name= "date", required = false) @Nullable Date createdDate){
        final ProductFetch productFetch = ProductFetch.builder().createdOn(createdDate).build();
        return productService.get(productFetch);
    }

    @DeleteMapping
    @Operation(summary = "Delete product by id")
    public void deleteProduct(final ProductDelete productDelete){
        productService.delete(productDelete);
    }

}
