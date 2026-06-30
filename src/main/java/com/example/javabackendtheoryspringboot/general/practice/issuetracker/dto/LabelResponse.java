package com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto;

import java.time.LocalDateTime;

public class LabelResponse {

    private Long id;
    private String name;
    private String color;
    private LocalDateTime createdAt;

    public LabelResponse(Long id,
                         String name,
                         String color,
                         LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.color = color;
        this.createdAt = createdAt;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}
