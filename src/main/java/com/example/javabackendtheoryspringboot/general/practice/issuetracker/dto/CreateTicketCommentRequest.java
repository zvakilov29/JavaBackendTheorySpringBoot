package com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTicketCommentRequest {

    @NotBlank(message = "Author name is required")
    @Size(max = 100, message = "Author name must not be longer than 100 characters")
    private String authorName;

    @NotBlank(message = "Comment content is required")
    @Size(max = 1000, message = "Comment content must not be longer than 1000 characters")
    private String content;

    public CreateTicketCommentRequest() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
