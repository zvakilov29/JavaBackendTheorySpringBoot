package com.example.javabackendtheoryspringboot.lesson29.homework;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException(String message){
        super(message);
    }
}
