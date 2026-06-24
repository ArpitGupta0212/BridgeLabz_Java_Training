package com.LibraryManagementSystem.validation;

import com.LibraryManagementSystem.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookValidator implements Validator<Book> {

    @Override
    public List<String> validate(Book book) {

        List<String> errors = new ArrayList<>();

        // Book ID Validation
        if (book.getBookId() <= 0) {

            errors.add("Book ID must be positive");
        }

        // Title Validation
        if (book.getTitle() == null || book.getTitle().isBlank()) {

            errors.add("Title cannot be empty");
        }

        // Author Validation
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {

            errors.add("Author cannot be empty");
        }

        // Genre Validation
        if (book.getGenre() == null || book.getGenre().isBlank()) {

            errors.add("Genre cannot be empty");
        }

        // ISBN Validation
        if (book.getIsbn() == null || !book.getIsbn().matches("[0-9]{10}|[0-9]{13}")) {

            errors.add("ISBN must contain 10 or 13 digits");
        }

        // Quantity Validation
        if (book.getQuantity() < 0) {

            errors.add("Quantity cannot be negative");
        }

        // Price Validation
        if (book.getPrice() <= 0) {

            errors.add("Price must be greater than zero");
        }

        return errors;
    }
}