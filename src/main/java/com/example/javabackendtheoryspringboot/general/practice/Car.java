package com.example.javabackendtheoryspringboot.general.practice;

public class Car {
    private Long id;
    private String model;
    private String color;
    private int productionYear;

    public Car() {}

    public  Car(Long id, String model, String color, int productionYear) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}
