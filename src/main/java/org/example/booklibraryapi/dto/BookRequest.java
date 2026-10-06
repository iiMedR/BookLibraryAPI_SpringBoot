package org.example.booklibraryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record BookRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title must not exceed 100 characters")
        String title,

        @NotBlank(message = "Author is required")
        @Size(max = 30, message = "Author must not exceed 30 characters")
        String author,

        @NotBlank(message = "ISBN is required")
        String isbn,

        @NotBlank(message = "publishedYear is required")
        String publishedYear
) {
}
