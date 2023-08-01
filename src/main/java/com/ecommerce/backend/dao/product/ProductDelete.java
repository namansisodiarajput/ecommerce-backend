package com.ecommerce.backend.dao.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class ProductDelete {

    @NonNull
    private String productId;
}
