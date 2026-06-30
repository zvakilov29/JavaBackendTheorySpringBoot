package com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto;

import java.time.LocalDateTime;

public class TicketCommentResponse {

    private Long id;
    private Long ticketId;
    private String authorName;
    private String content;
    private LocalDateTime createdAt;

    public TicketCommentResponse(Long id,
                                 Long ticketId,
                                 String authorName,
                                 String content,
                                 LocalDateTime createdAt) {
        this.id = id;
        this.ticketId = ticketId;
        this.authorName = authorName;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
