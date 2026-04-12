package com.example.javabackendtheoryspringboot.lesson27.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentGateway paymentGateway;

    public OrderService(@Qualifier("stripeGateway") PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void placeOrder(String productName, double amount){
        System.out.println("Placing order for: " + productName);
        paymentGateway.processPayment(amount);
        System.out.println("Order completed successfully!");
    }
}
