package com.example.javabackendtheoryspringboot.general.practice.foundation.library.mapper;

import com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain.Book;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.dto.BookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthorName(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getStatus(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }
}
