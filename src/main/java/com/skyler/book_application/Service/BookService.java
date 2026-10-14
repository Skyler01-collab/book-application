package com.skyler.book_application.Service;

import com.skyler.book_application.Entity.Book;
import com.skyler.book_application.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book getBook(String name) {
        return bookRepository.findByTitle(name);
    }

    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setGenre(book.getGenre());
            bookRepository.save(existingBook);
            return existingBook;
        }
        return null;
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
