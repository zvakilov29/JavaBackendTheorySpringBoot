package com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketStatus;

public class InvalidTicketStatusTransitionException extends RuntimeException {

    public InvalidTicketStatusTransitionException(TicketStatus currentStatus, TicketStatus newStatus) {
        super("Cannot change ticket status from " + currentStatus + " to " + newStatus + ".");
    }
}
