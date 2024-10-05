package com.personal.library.library_management.controller;

import com.personal.library.library_management.entity.Book;
import com.personal.library.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book = bookService.addBook(book);
        return new ResponseEntity<>(book, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable UUID id) {
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatusCode.valueOf(200));
    }

}
