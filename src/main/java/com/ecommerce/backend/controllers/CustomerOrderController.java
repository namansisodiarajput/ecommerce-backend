package com.ecommerce.backend.controllers;

import com.ecommerce.backend.dao.order.CustomerOrderCreate;
import com.ecommerce.backend.dao.order.CustomerOrderFetch;
import com.ecommerce.backend.entities.CustomerOrder;
import com.ecommerce.backend.services.CustomerOrderService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce-backend/customer-order")
@AllArgsConstructor
public class CustomerOrderController {

    @Autowired
    private final CustomerOrderService customerOrderService;

    @PostMapping
    @Operation(summary = "Create new customer order")
    public void createCustomerOrder(final CustomerOrderCreate customerOrderCreate){
        customerOrderService.create(customerOrderCreate);
    }

    @GetMapping
    @Operation(summary = "Get all order booked by customer")
    public List<CustomerOrder> getCustomerOrder(@RequestParam(required = true) final String email) {
        final CustomerOrderFetch customerOrderFetch = CustomerOrderFetch.builder().email(email).build();
        return customerOrderService.getByCustomer(customerOrderFetch);
    }
}
