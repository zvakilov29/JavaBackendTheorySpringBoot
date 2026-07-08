package com.example.javabackendtheoryspringboot.general.practice.foundation.library.dto;

import com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain.BookStatus;

import java.time.LocalDateTime;

public class BookResponse {

    private Long id;
    private String title;
    private String authorName;
    private String isbn;
    private Integer publicationYear;
    private BookStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BookResponse(Long id,
                        String title,
                        String authorName,
                        String isbn,
                        Integer publicationYear,
                        BookStatus status,
                        LocalDateTime createdAt,
                        LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public BookStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
