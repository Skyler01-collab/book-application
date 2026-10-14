package com.skyler.book_application.Controller;

import com.skyler.book_application.Entity.Book;
import com.skyler.book_application.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books/v1")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
       Book booked=bookService.addBook(book);
        return ResponseEntity.ok(booked);
    }

    @GetMapping("/getBook/{name}")
    public ResponseEntity<Book> getBook(@PathVariable String name) {
        Book book = bookService.getBook(name);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book bookupdate=bookService.updateBook(book);
        return ResponseEntity.ok(bookupdate);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
