package com.ecommerce.backend.dao.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class CustomerFetch {
    @NonNull
    private String email;
}
