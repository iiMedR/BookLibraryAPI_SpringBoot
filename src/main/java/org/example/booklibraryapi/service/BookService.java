package org.example.booklibraryapi.service;


import jakarta.transaction.Transactional;
import org.example.booklibraryapi.dto.BookResponse;
import org.example.booklibraryapi.dto.BookRequest;
import org.example.booklibraryapi.exception.BookNotFoundException;
import org.example.booklibraryapi.model.Book;
import org.example.booklibraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookResponse toResponse(Book book){
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishedYear(), book.isAvailable());
    }

}
