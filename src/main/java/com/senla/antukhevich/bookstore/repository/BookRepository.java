package com.senla.antukhevich.bookstore.repository;

import com.senla.antukhevich.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByName(String name);
}
