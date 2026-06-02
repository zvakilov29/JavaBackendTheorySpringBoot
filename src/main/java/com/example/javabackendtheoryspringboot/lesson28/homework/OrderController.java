package com.example.javabackendtheoryspringboot.lesson28.homework;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final ObjectProvider<ShoppingCart> shoppingCartProvider;
    private final PaymentService paymentService;

    public OrderController(ObjectProvider<ShoppingCart> shoppingCartProvider, PaymentService paymentService) {
        this.shoppingCartProvider = shoppingCartProvider;
        this.paymentService = paymentService;
    }

    @PostMapping("/orders")
    public String createOrder(@RequestParam String productName){
        ShoppingCart shoppingCart = shoppingCartProvider.getObject();
        shoppingCart.addProduct(productName);
        return paymentService.acceptPayment(shoppingCart.getProducts());
    }
}
