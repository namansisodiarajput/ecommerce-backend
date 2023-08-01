package com.ecommerce.backend.dao.customer;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdate {

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private Integer age;
    @NonNull
    private String address;
}
