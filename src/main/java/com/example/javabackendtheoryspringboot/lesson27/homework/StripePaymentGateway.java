package com.example.javabackendtheoryspringboot.lesson27.homework;

import org.springframework.stereotype.Component;

@Component("stripeGateway")
public class StripePaymentGateway implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println(amount + " amount was paid via Stripe");
    }
}
