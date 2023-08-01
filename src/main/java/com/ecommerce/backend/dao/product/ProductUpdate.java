package com.ecommerce.backend.dao.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class ProductUpdate {

    @NonNull
    private String productId;
    @NonNull
    private String name;
    @NonNull
    private int price;
    @NonNull
    private int quantity;
    @NonNull
    private String description;
}
