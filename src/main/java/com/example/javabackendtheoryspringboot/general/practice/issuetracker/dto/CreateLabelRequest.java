package com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateLabelRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must not be longer than 50 characters")
    private String name;

    @NotBlank(message = "Color is required")
    @Size(max = 20, message = "Color must not be longer than 20 characters")
    private String color;

    public CreateLabelRequest() {
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
