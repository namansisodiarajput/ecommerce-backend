package com.ecommerce.backend.controllers;

import com.ecommerce.backend.dao.product.ProductCreate;
import com.ecommerce.backend.dao.product.ProductUpdate;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Get all product details")
    public List<Product> getProductDetails(){
        return productService.getAllProduct();
    }

    @DeleteMapping
    @Operation(summary = "Delete product by id")
    public void deleteProduct(@RequestParam(required = true) final String productId){
        final ProductDelete productDelete = ProductDelete.builder().productId(productId).build();
        productService.delete(productDelete);
    }
}
