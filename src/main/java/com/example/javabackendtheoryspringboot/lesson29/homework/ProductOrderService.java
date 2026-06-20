package com.example.javabackendtheoryspringboot.lesson29.homework;

import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {

    public String orderProduct(String productName){
        if(productName.equalsIgnoreCase("laptop")){
            throw new ProductOutOfStockException("Product '" + productName + "' is out of stock.");
        }

        return "Order accepted for product: " + productName;
    }
}
