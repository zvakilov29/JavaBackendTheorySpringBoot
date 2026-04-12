package com.example.javabackendtheoryspringboot.lesson27.homework;

import org.springframework.stereotype.Component;

@Component("payPalGateway")
public class PayPalPaymentGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println(amount + " amount was paid via PayPal");
    }
}
