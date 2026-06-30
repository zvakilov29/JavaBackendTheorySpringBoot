package com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketStatus;
import jakarta.validation.constraints.NotNull;

public class UpdateTicketStatusRequest {
    @NotNull(message = "Status is required")
    private TicketStatus status;

    public UpdateTicketStatusRequest() {
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
