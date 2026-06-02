package com.example.javabackendtheoryspringboot.lesson29.homework;

public class Car {
    private String model;
    private String color;
    private int productionYear;

    public Car() {
        this.model = "";
        this.color = "";
        this.productionYear = 0;
    }

    public  Car(String model, String color, int productionYear) {
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
