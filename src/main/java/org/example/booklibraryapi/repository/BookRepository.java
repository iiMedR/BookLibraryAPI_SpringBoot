package org.example.booklibraryapi.repository;

import org.example.booklibraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
