package com.LibraryManagementSystem.threads;

import com.LibraryManagementSystem.io.FileOperations;
import com.LibraryManagementSystem.model.Book;
import com.LibraryManagementSystem.service.LibraryService;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentBorrowSimulator {

    public static void runHighConcurrencyTest(LibraryService libraryService, List<Book> booksList) {

        long startTime = System.currentTimeMillis();

        Random random = new Random();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 1000; i++) {

                int id = i;

                executor.submit(() -> {

                    try {

                        String patron = "user" + id;

                        int randomBookId =

                                booksList.get(random.nextInt(booksList.size())).getBookId();

                        boolean success =

                                libraryService.borrowBook(patron, randomBookId);

                        if (success) {

                            FileOperations.writeReceipt(

                                    "receipts/txn_" + id + ".txt",

                                    "===== LIBRARY RECEIPT =====\n" + "Transaction : TXN-" + id + "\n"

                                            +

                                            "User : " + patron + "\n"

                                            +

                                            "Book ID : " + randomBookId + "\n"

                                            +

                                            "Status : Borrowed\n"

                                            +

                                            "Thread : " + Thread.currentThread() + "\n");
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("\nVirtual Thread Test Completed");

        System.out.println("Execution Time : " + (endTime - startTime) + " ms");
    }
}