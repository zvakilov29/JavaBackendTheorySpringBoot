package com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception;

public class DuplicateTicketLabelAssignmentException extends RuntimeException {

    public DuplicateTicketLabelAssignmentException(Long ticketId, Long labelId) {
        super("Label with ID " + labelId + " is already assigned to ticket with ID " + ticketId + ".");
    }
}
