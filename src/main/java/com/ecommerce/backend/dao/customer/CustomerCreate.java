package com.ecommerce.backend.dao.customer;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreate {

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private int age;
    @NonNull
    private String address;
}
