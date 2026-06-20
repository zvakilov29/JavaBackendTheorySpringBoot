package com.example.javabackendtheoryspringboot.lesson29.homework;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService){

        this.productOrderService = productOrderService;
    }

    @PostMapping("/api/v1/orders")
    public String createOrder(@RequestParam String productName) {
        return productOrderService.orderProduct(productName);
    }
}
