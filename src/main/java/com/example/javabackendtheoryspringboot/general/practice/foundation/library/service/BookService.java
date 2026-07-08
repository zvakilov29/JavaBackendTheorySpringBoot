package com.example.javabackendtheoryspringboot.general.practice.foundation.library.service;

import com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain.Book;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = Objects.requireNonNull(bookRepository, "bookRepository must not be null");
    }

    public Book createBook(String title, String authorName, String isbn, Integer publicationYear) {
        validateIsbn(isbn);
        ensureIsbnDoesNotExist(isbn);

        Book newBook = new Book(bookRepository.nextId(), title, authorName, isbn, publicationYear);

        return bookRepository.save(newBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        validateId(id);

        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
    }

    public Book updateBook(Long id, String title, String authorName, String isbn, Integer publicationYear) {
        Book bookToUpdate = getBookById(id);

        validateIsbn(isbn);
        ensureIsbnIsNotUsedByAnotherBook(bookToUpdate, isbn);

        bookToUpdate.updateDetails(title, authorName, isbn, publicationYear);

        return bookRepository.save(bookToUpdate);
    }

    public Book borrowBook(Long id) {
        Book bookToBorrow = getBookById(id);
        bookToBorrow.borrow();
        return bookRepository.save(bookToBorrow);
    }

    public Book returnBook(Long id) {
        Book bookToReturn = getBookById(id);
        bookToReturn.returnBook();
        return bookRepository.save(bookToReturn);
    }

    public Book archiveBook(Long id) {
        Book bookToArchive = getBookById(id);
        bookToArchive.archive();
        return bookRepository.save(bookToArchive);
    }

    public void deleteBook(Long id) {
        getBookById(id);
        bookRepository.deleteById(id);
    }

    private void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Book ID must be positive");
        }
    }

    private void validateIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN must not be blank");
        }
    }

    private void ensureIsbnDoesNotExist(String isbn) {
        if (bookRepository.findByIsbn(isbn).isPresent()) {
            throw new IllegalArgumentException("Book with this ISBN already exists");
        }
    }

    private void ensureIsbnIsNotUsedByAnotherBook(Book bookToUpdate, String isbn) {
        bookRepository.findByIsbn(isbn)
                .ifPresent(foundBook -> {
                    if (!bookToUpdate.getId().equals(foundBook.getId())) {
                        throw new IllegalArgumentException("Another book with this ISBN already exists");
                    }
                });
    }
}