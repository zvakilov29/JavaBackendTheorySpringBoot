package com.example.javabackendtheoryspringboot.general.practice.foundation.library;

import com.example.javabackendtheoryspringboot.general.practice.foundation.library.domain.Book;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.repository.BookRepository;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.repository.InMemoryBookRepository;
import com.example.javabackendtheoryspringboot.general.practice.foundation.library.service.BookService;

public class LibraryPracticeMain {

    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        BookService bookService = new BookService(bookRepository);

        Book book1 = bookService.createBook(
                "Clean Code",
                "Robert C. Martin",
                "ISBN-111",
                2008
        );

        System.out.println("Created book:");
        printBook(book1);

        System.out.println("\nAll books:");
        bookService.getAllBooks().forEach(LibraryPracticeMain::printBook);

        Book borrowedBook = bookService.borrowBook(book1.getId());

        System.out.println("\nAfter borrowing:");
        printBook(borrowedBook);

        runScenario("Try to borrow the same book again", () -> {
            bookService.borrowBook(book1.getId());
        });

        Book returnedBook = bookService.returnBook(book1.getId());

        System.out.println("\nAfter returning:");
        printBook(returnedBook);

        Book updatedBook = bookService.updateBook(
                book1.getId(),
                "Clean Code Updated",
                "Robert C. Martin",
                "ISBN-111",
                2009
        );

        System.out.println("\nAfter update:");
        printBook(updatedBook);

        runScenario("Try to create another book with same ISBN", () -> {
            bookService.createBook(
                    "Another Book",
                    "Some Author",
                    "ISBN-111",
                    2020
            );
        });

        Book archivedBook = bookService.archiveBook(book1.getId());

        System.out.println("\nAfter archiving:");
        printBook(archivedBook);

        runScenario("Try to borrow archived book", () -> {
            bookService.borrowBook(book1.getId());
        });

        bookService.deleteBook(book1.getId());

        System.out.println("\nBook deleted.");

        runScenario("Try to get deleted book", () -> {
            bookService.getBookById(book1.getId());
        });
    }

    private static void printBook(Book book) {
        System.out.println(
                "Book{" +
                        "id=" + book.getId() +
                        ", title='" + book.getTitle() + '\'' +
                        ", authorName='" + book.getAuthorName() + '\'' +
                        ", isbn='" + book.getIsbn() + '\'' +
                        ", publicationYear=" + book.getPublicationYear() +
                        ", status=" + book.getStatus() +
                        ", createdAt=" + book.getCreatedAt() +
                        ", updatedAt=" + book.getUpdatedAt() +
                        '}'
        );
    }

    private static void runScenario(String scenarioName, Runnable action) {
        try {
            action.run();
            System.out.println("\n" + scenarioName + ": unexpectedly succeeded");
        } catch (RuntimeException exception) {
            System.out.println("\n" + scenarioName + ": failed as expected");
            System.out.println("Reason: " + exception.getMessage());
        }
    }
}