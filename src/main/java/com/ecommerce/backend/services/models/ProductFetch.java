package com.ecommerce.backend.services.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProductFetch {
    private Date createdOn;

}
