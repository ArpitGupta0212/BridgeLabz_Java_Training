package com.LibraryManagementSystem;

import com.LibraryManagementSystem.io.CsvHandler;
import com.LibraryManagementSystem.io.FileOperations;
import com.LibraryManagementSystem.io.JsonHandler;
import com.LibraryManagementSystem.service.LibraryService;
import com.LibraryManagementSystem.ui.MenuDriver;

public class Main {

    public static void main(String[] args) {

        try {

            // Create receipts folder
            FileOperations.verifyDirectories("receipts");

            // Service Object
            LibraryService libraryService = new LibraryService();

            // Load Books
            libraryService.loadBooks(

                    CsvHandler.readBooksFromCsv("src/main/resources/books.csv"));

            // Validate JSON Schema
            boolean valid =

                    JsonHandler.validateJsonSchema(

                            "src/main/resources/transactions.json",

                            "src/main/resources/transaction-schema.json");

            if (valid) {

                libraryService.loadTransactions(

                        JsonHandler.readTransactionsFromJson(

                                "src/main/resources/transactions.json"));
            }

            // Start Menu
            System.out.println("Before Menu");
            MenuDriver menu = new MenuDriver(libraryService);

            menu.start();

            System.out.println("After Menu");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}