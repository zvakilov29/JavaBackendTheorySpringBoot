package com.example.javabackendtheoryspringboot.lesson27.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HomeworkMain {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            OrderService orderService = context.getBean(OrderService.class);
            orderService.placeOrder("Laptop", 2500.0);
        }
    }
}
