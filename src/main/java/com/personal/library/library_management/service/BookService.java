package com.personal.library.library_management.service;

import com.personal.library.library_management.entity.Book;
import com.personal.library.library_management.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        log.info("Saving a new book");
        Book savedBook = this.bookRepository.save(book);
        log.info("Saved the book with ID {}", savedBook.getId());
        return savedBook;
    }


    public List<Book> getAllBooks() {
        log.info("Getting all books");
        List<Book> bookList = this.bookRepository.findAll();
        return bookList;
    }

    public Book findBookById(UUID id) {
        log.info("Finding book of id : {}", id);
        Optional<Book> book = this.bookRepository.findById(id);
        return book.get();
    }
}
