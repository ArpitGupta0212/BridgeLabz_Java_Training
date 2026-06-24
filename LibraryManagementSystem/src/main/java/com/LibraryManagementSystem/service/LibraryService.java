package com.LibraryManagementSystem.service;

import com.LibraryManagementSystem.model.Book;
import com.LibraryManagementSystem.model.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class LibraryService {

    private final Map<String, List<Transaction>> userTransactions = new ConcurrentHashMap<>();
    private final Map<Integer, Integer> bookBorrowCounts = new ConcurrentHashMap<>();
    private final List<Book> books = new CopyOnWriteArrayList<>();
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    // Load Books
    public void loadBooks(List<Book> bookList) {

        books.clear();
        books.addAll(bookList);
    }


    // Load Transactions
    public void loadTransactions(List<Transaction> transactionList) {

        transactions.clear();

        transactions.addAll(transactionList);

        transactionList.forEach(t ->

                userTransactions.computeIfAbsent(t.getPatronName(), k -> new ArrayList<>()).add(t));
    }


    // Get All Books
    public List<Book> getBooks() {

        return books;
    }


    // Get All Transactions
    public List<Transaction> getTransactions() {

        return transactions;
    }


    // Search Books using Stream API
    public List<Book> searchBooks(String query, String searchBy) {

        return books.stream()

                .filter(book -> {

                    switch (searchBy) {

                        case "Title":

                            return book.getTitle().toLowerCase().contains(query.toLowerCase());

                        case "Author":

                            return book.getAuthor().toLowerCase().contains(query.toLowerCase());

                        case "Genre":

                            return book.getGenre().equalsIgnoreCase(query);

                        default:

                            return false;
                    }

                })

                .collect(Collectors.toList());
    }


    // Borrow Book
    public synchronized boolean borrowBook(String username, int bookId) {

        Optional<Book> book =

                books.stream()

                        .filter(b -> b.getBookId() == bookId)

                        .findFirst();

        if (book.isEmpty() || book.get().getQuantity() <= 0) {

            return false;
        }

        book.get().setQuantity(

                book.get().getQuantity() - 1);

        Transaction transaction =

                new Transaction(

                        "TXN-" + UUID.randomUUID(),

                        username,

                        bookId,

                        LocalDate.now().toString(),

                        LocalDate.now().plusDays(7).toString(),

                        "Borrowed");

        transactions.add(transaction);

        userTransactions

                .computeIfAbsent(username, k -> new ArrayList<>())

                .add(transaction);

        bookBorrowCounts.merge(

                bookId,

                1,

                Integer::sum);

        return true;
    }


    // Return Book
    public synchronized boolean returnBook(String username, int bookId) {

        Optional<Transaction> transaction =

                transactions.stream()

                        .filter(t ->

                                t.getPatronName().equals(username)

                                        &&

                                        t.getBookId() == bookId

                                        &&

                                        t.getStatus().equals("Borrowed"))

                        .findFirst();

        if (transaction.isPresent()) {

            transaction.get().setStatus("Returned");

            books.stream()

                    .filter(b -> b.getBookId() == bookId)

                    .findFirst()

                    .ifPresent(b -> b.setQuantity(b.getQuantity() + 1));

            return true;
        }

        return false;
    }


    // User Borrow History
    public List<Transaction> getPatronHistory(String username) {

        return userTransactions.getOrDefault(username, Collections.emptyList());
    }


    // Remove Cancelled Transactions
    public void evictCancelledTransactions() {

        transactions.removeIf(

                t -> t.getStatus().equalsIgnoreCase("Cancelled"));
    }


    // Total Catalog Value
    public double calculateTotalCatalogValue() {

        return books.stream()

                .mapToDouble(b -> b.getPrice() * b.getQuantity())

                .sum();
    }


    // Group Books By Genre
    public Map<String, List<Book>> groupBooksByGenre() {

        return books.stream()

                .collect(

                        Collectors.groupingBy(Book::getGenre));
    }


    // Most Borrowed Books
    public Map<Integer, Integer> getBookBorrowCounts() {

        return bookBorrowCounts;
    }
}