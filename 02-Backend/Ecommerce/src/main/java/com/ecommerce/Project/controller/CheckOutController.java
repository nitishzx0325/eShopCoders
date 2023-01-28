package com.ecommerce.Project.controller;

import com.ecommerce.Project.dto.Purchase;
import com.ecommerce.Project.dto.PurchaseResponse;
import com.ecommerce.Project.service.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("api/checkout")
public class CheckOutController {

    private CheckoutService checkoutService;
    @Autowired
    public CheckOutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        log.info("inside place order"+purchase);
        PurchaseResponse purchaseResponse=checkoutService.placeOrder(purchase);
        log.info("order palced succesfful");
        return purchaseResponse;
    }


}
