package com.ecommerce.backend.services.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerFetch {

    private String email;
}
