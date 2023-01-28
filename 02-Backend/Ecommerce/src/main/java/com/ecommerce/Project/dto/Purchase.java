package com.ecommerce.Project.dto;

import com.ecommerce.Project.entity.Address;
import com.ecommerce.Project.entity.Customer;
import com.ecommerce.Project.entity.Order;
import com.ecommerce.Project.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
