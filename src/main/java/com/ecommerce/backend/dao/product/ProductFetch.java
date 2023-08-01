package com.ecommerce.backend.dao.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class ProductFetch {

    @NonNull
    private Date createdOn;
}
