package com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception;

public class LabelNotFoundException extends RuntimeException {

    public LabelNotFoundException(Long labelId) {
        super("Label with ID " + labelId + " was not found.");
    }
}
