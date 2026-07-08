package com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain;

import java.time.LocalDateTime;

public class Book {
    private Long id;
    private String title;
    private String authorName;
    private String isbn;
    private Integer publicationYear;
    private BookStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Book(Long id,
                String title,
                String authorName,
                String isbn,
                Integer publicationYear) {
        this.validateDetails(title, authorName, isbn, publicationYear);
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;

        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
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

    public void updateDetails(String title,
                              String authorName,
                              String isbn,
                              Integer publicationYear) {
        this.validateDetails(title, authorName, isbn, publicationYear);

        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;

        this.markUpdated();
    }

    public void borrow() {
        if (this.status != BookStatus.AVAILABLE) {
            throw new IllegalStateException("The book is not currently available for borrowing");
        }

        this.status = BookStatus.BORROWED;
        this.markUpdated();
    }

    public void returnBook() {
        if (this.status != BookStatus.BORROWED) {
            throw new IllegalStateException("The book is either archived or already available and cannot be returned");
        }

        this.status = BookStatus.AVAILABLE;
        this.markUpdated();
    }

    public void archive() {
        if (status == BookStatus.ARCHIVED) {
            return;
        }

        this.status = BookStatus.ARCHIVED;
        this.markUpdated();
    }

    private void markUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    private void validateDetails(String title, String authorName, String isbn, Integer publicationYear) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title must not be blank");
        }

        if (authorName == null || authorName.isBlank()) {
            throw new IllegalArgumentException("Author name must not be blank");
        }

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN must not be blank");
        }

        if (publicationYear != null && publicationYear < 0) {
            throw new IllegalArgumentException("Publication year must not be negative");
        }
    }
}
