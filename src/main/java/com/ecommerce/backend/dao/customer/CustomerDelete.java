package com.ecommerce.backend.dao.customer;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class CustomerDelete {

    @NonNull
    private String email;
}
