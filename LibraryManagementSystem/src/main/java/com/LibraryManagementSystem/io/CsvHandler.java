package com.LibraryManagementSystem.io;

import com.LibraryManagementSystem.model.Book;
import com.LibraryManagementSystem.validation.BookValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {

    public static List<Book> readBooksFromCsv(String filePath) throws IOException {

        List<Book> books = new ArrayList<>();

        BookValidator validator = new BookValidator();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip Header
            br.readLine();

            while ((line = br.readLine()) != null) {

                try {

                    String[] columns = line.split(",");

                    Book book = new Book(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], Integer.parseInt(columns[5]), Double.parseDouble(columns[6]));

                    List<String> errors = validator.validate(book);

                    if (errors.isEmpty()) {

                        books.add(book);

                    } else {

                        System.out.println("Validation Failed : " + errors);
                    }

                } catch (NumberFormatException e) {

                    System.out.println("Corrupted Row : " + line);
                }
            }
        }

        return books;
    }

    public static void writeBooksToCsv(String filePath, List<Book> books) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write("BookID,Title,Author,Genre,ISBN,Quantity,Price");

            bw.newLine();

            for (Book book : books) {

                bw.write(book.getBookId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getIsbn() + "," + book.getQuantity() + "," + book.getPrice());

                bw.newLine();
            }
        }
    }
}