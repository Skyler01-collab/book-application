package com.skyler.book_application.Repository;

import com.skyler.book_application.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByTitle(String name);
}
