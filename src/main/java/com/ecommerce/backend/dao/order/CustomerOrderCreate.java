package com.ecommerce.backend.dao.order;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class CustomerOrderCreate {

    @NonNull
    private String email;
    @NotNull
    private String productId;
}
