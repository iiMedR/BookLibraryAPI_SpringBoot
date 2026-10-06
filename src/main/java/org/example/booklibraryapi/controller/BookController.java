package org.example.booklibraryapi.controller;

import jakarta.validation.Valid;
import org.example.booklibraryapi.dto.BookRequest;
import org.example.booklibraryapi.dto.BookResponse;
import org.example.booklibraryapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookResponse createBook(@Valid @RequestBody BookRequest Request) {
        return bookService.createBook(Request);
    }

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest Request) {
        return ResponseEntity.ok(bookService.updateBookById(id, Request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
