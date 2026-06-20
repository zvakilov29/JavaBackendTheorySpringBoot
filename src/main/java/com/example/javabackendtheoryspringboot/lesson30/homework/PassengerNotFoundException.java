package com.example.javabackendtheoryspringboot.lesson30.homework;

public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(String message) {
        super(message);
    }
}
