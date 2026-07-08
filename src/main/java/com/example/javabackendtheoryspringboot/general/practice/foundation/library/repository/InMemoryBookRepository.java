package com.example.javabackendtheoryspringboot.general.practice.foundation.library.repository;

import com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private final Map<Long, Book> booksById = new LinkedHashMap<>();
    private Long nextId = 1L;

    @Override
    public Long nextId() {
        return nextId++;
    }

    @Override
    public Book save(Book book) {
        booksById.put(book.getId(), book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(booksById.values());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(booksById.get(id));
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book : booksById.values()) {
            if (book.getIsbn().equals(isbn)) {
                return Optional.of(book);
            }
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        booksById.remove(id);
    }
}
