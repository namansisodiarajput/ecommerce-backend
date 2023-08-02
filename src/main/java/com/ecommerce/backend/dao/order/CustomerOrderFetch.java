package com.ecommerce.backend.dao.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class CustomerOrderFetch {

    @NonNull
    private String email;
}
