package com.LibraryManagementSystem.validation;

import com.LibraryManagementSystem.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookValidator implements Validator<Book> {

    @Override
    public List<String> validate(Book book) {

        List<String> errors = new ArrayList<>();

        if (book.getBookId() <= 0) errors.add("Book ID must be positive");

        if (book.getTitle() == null || book.getTitle().isBlank()) errors.add("Title required");

        if (book.getAuthor() == null || book.getAuthor().isBlank()) errors.add("Author required");

        if (!book.getIsbn().matches("[0-9]{10}|[0-9]{13}")) {
            errors.add("Invalid ISBN");
        }

        if (book.getQuantity() < 0) errors.add("Quantity invalid");

        if (book.getPrice() <= 0) errors.add("Price invalid");

        return errors;
    }
}
