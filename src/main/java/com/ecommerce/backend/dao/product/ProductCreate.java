package com.ecommerce.backend.dao.product;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ProductCreate {

    @NonNull
    private String name;
    @NonNull
    private int price;
    @NonNull
    private int quantity;
    @NonNull
    private String description;
}
