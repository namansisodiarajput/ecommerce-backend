package com.ecommerce.backend.dao.order;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerOrderDelete {

    @NotNull
    private String orderId;
}
