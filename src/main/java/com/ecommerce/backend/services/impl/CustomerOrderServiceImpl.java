package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.dao.customer.CustomerFetch;
import com.ecommerce.backend.dao.order.CustomerOrderCreate;
import com.ecommerce.backend.dao.order.CustomerOrderFetch;
import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.entities.CustomerOrder;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.repositories.CustomerOrderRepo;
import com.ecommerce.backend.services.CustomerOrderService;
import com.ecommerce.backend.services.CustomerService;
import com.ecommerce.backend.services.ProductService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private final CustomerOrderRepo customerOrderRepo;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final ProductService productService;

    @Override
    public void create(final CustomerOrderCreate customerOrderCreate) {

        final Customer customer = fetchCustomer(customerOrderCreate.getEmail());
        final Product product = fetchProduct(customerOrderCreate.getProductId());

        final Optional<CustomerOrder> customerOrderOptional = fetchExistingOrderIfExist(customer.getCustomerId(),
                product.getProductId());

        if(customerOrderOptional.isPresent())
            return;

        final CustomerOrder customerOrder = CustomerOrder
                .builder()
                .orderId(UUID.randomUUID().toString())
                .productDetails(product)
                .customerDetail(customer)
                .createdOn(new Date())
                .modifiedOn(new Date())
                .build();

        customerOrderRepo.save(customerOrder);

    }

    @Override
    public List<CustomerOrder> getByCustomer(final CustomerOrderFetch customerOrderFetch) {

        final Customer customer = fetchCustomer(customerOrderFetch.getEmail());

        return customerOrderRepo.findCustomerOrderByCustomerDetail(customer.getCustomerId());
    }

    private Customer fetchCustomer(final String email) {

        final CustomerFetch customerFetch = CustomerFetch.builder()
                .email(email)
                .build();

        return customerService.get(customerFetch);
    }

    private Product fetchProduct(final String productId) {

        return productService.getProductById(productId);
    }

    private Optional<CustomerOrder> fetchExistingOrderIfExist(final String customerId, final String productId) {

        return customerOrderRepo.findCustomerOrderByCustomerDetailAndProductDetails(
                customerId, productId);
    }
}
