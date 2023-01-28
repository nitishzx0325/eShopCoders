package com.ecommerce.Project.service;

import com.ecommerce.Project.dao.CustomerRepository;
import com.ecommerce.Project.dto.Purchase;
import com.ecommerce.Project.dto.PurchaseResponse;
import com.ecommerce.Project.entity.Customer;
import com.ecommerce.Project.entity.Order;
import com.ecommerce.Project.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
//        retrive the order info from dto
        Order order=purchase.getOrder();

//        generate tracking number
        String orderTrackingNumber=generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);


//        populate order with order Item
        Set<OrderItem> orderItems=purchase.getOrderItems();
        orderItems.forEach(item->order.add(item));


//        populate order with billingAddress and shippingAddress
            order.setBillingAddress(purchase.getBillingAddress());
            order.setShippingAddress(purchase.getShippingAddress());

//        populate customer with order
        Customer customer=purchase.getCustomer();

        String theEmail=customer.getEmail(  );
        Customer customerfromDB=customerRepository.findByEmail(theEmail);

        if(customerfromDB!=null){
            customer=customerfromDB;
        }

        customer.add(order);
//        save to the database
        customerRepository.save(customer);
//        return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
//        generate random UUID number
        return UUID.randomUUID().toString();
    }
}
