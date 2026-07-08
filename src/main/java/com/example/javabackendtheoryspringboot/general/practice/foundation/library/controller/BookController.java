package com.example.javabackendtheoryspringboot.general.practice.foundation.library.controller;

import com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain.Book;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.dto.BookResponse;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.dto.CreateBookRequest;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.mapper.BookMapper;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/foundation/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;
    
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest request) {
        Book createdBook = bookService.createBook(
                request.getTitle(),
                request.getAuthorName(),
                request.getIsbn(),
                request.getPublicationYear()
        );

        BookResponse response = bookMapper.toResponse(createdBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        BookResponse response = bookMapper.toResponse(book);

        return ResponseEntity.ok(response);
    }
}
