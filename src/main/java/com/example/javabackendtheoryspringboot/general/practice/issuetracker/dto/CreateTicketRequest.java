package com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTicketRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not be longer than 100 characters")
    private String title;

    @Size(max = 1000, message = "Description must not be longer than 1000 characters")
    private String description;

    @NotNull(message = "Priority is required")
    private TicketPriority priority;

    public CreateTicketRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }
}
