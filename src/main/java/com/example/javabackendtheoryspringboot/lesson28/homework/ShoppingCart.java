package com.example.javabackendtheoryspringboot.lesson28.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ShoppingCart {
    private final List<String> products = new ArrayList<>();

    public void addProduct(String productName){
        products.add(productName);
    }

    public List<String> getProducts(){
        return products;
    }
}
