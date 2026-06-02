package com.example.javabackendtheoryspringboot.lesson28.homework;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @PostConstruct
    public void connectToBank(){
        System.out.println("Connected to the bank system.");
    }

    @PreDestroy
    public void disconnectFromBank(){
        System.out.println("Disconnected from the bank system.");
    }

    public String acceptPayment(List<String> products){
        return "Payment accepted for products: " +  products;
    }
}
