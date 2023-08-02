package com.ecommerce.backend.services;

import com.ecommerce.backend.dao.order.CustomerOrderCreate;
import com.ecommerce.backend.dao.order.CustomerOrderFetch;
import com.ecommerce.backend.entities.CustomerOrder;
import java.util.List;

public interface CustomerOrderService {

    void create(final CustomerOrderCreate customerOrderCreate);

    List<CustomerOrder> getByCustomer(final CustomerOrderFetch customerOrderFetch);
}
