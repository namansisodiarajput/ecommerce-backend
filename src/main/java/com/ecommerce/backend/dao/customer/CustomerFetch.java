package com.ecommerce.backend.dao.customer;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CustomerFetch {

    @NonNull
    private String email;
}
