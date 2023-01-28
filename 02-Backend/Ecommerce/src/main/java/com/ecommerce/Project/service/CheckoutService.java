package com.ecommerce.Project.service;

import com.ecommerce.Project.dto.Purchase;
import com.ecommerce.Project.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
