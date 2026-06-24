package com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception;

public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException(Long ticketId) {
        super("Ticket with ID " + ticketId + " was not found.");
    }
}
