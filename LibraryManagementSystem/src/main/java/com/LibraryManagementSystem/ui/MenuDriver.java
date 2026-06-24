package com.LibraryManagementSystem.ui;

import com.LibraryManagementSystem.model.Book;
import com.LibraryManagementSystem.model.User;
import com.LibraryManagementSystem.service.LibraryService;
import com.LibraryManagementSystem.threads.ConcurrentBorrowSimulator;
import com.LibraryManagementSystem.threads.ThreadStateTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDriver {

    private final LibraryService libraryService;

    private final Scanner scanner = new Scanner(System.in);

    private final List<User> users = new ArrayList<>();

    public MenuDriver(LibraryService libraryService) {

        this.libraryService = libraryService;
    }

    public void start() {

        seedUsers();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Login");

            System.out.println("2. Register");

            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    register();
                    break;

                case 3:

                    System.out.println("Thank You");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }

    private void seedUsers() {

        users.add(new User("admin", "admin123", "Librarian"));

        users.add(new User("arpit", "pass123", "Patron"));
    }

    private void register() {

        System.out.print("Username : ");

        String username = scanner.nextLine();

        System.out.print("Password : ");

        String password = scanner.nextLine();

        users.add(new User(username, password, "Patron"));

        System.out.println("Registration Successful");
    }

    private void login() {

        System.out.print("Username : ");

        String username = scanner.nextLine();

        System.out.print("Password : ");

        String password = scanner.nextLine();

        for (User user : users) {

            if (user.getUsername().equals(username)

                    &&

                    user.getPassword().equals(password)) {

                System.out.println("\nLogin Successful");

                if (user.getRole().equals("Librarian")) {

                    showLibrarianMenu();

                } else {

                    showPatronMenu(username);
                }

                return;
            }
        }

        System.out.println("Invalid Credentials");
    }

    private void showLibrarianMenu() {

        while (true) {

            System.out.println("\n===== LIBRARIAN MENU =====");

            System.out.println("1. View Catalog");

            System.out.println("2. View Transactions");

            System.out.println("3. Thread Lifecycle Demo");

            System.out.println("4. Virtual Thread Demo");

            System.out.println("5. Catalog Value");

            System.out.println("6. Group Books By Genre");

            System.out.println("7. Logout");

            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    libraryService.getBooks().forEach(System.out::println);

                    break;

                case 2:

                    libraryService.getTransactions().forEach(System.out::println);

                    break;

                case 3:

                    ThreadStateTracker.demonstrateLifecycle();

                    break;

                case 4:

                    ConcurrentBorrowSimulator.runHighConcurrencyTest(libraryService, libraryService.getBooks());

                    break;

                case 5:

                    System.out.println("Catalog Value : " + libraryService.calculateTotalCatalogValue());

                    break;

                case 6:

                    System.out.println(libraryService.groupBooksByGenre());

                    break;

                case 7:

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }

    private void showPatronMenu(String username) {

        while (true) {

            System.out.println("\n===== PATRON MENU =====");

            System.out.println("1. View Books");

            System.out.println("2. Search Book");

            System.out.println("3. Borrow Book");

            System.out.println("4. Return Book");

            System.out.println("5. My History");

            System.out.println("6. Logout");

            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    libraryService.getBooks().forEach(System.out::println);

                    break;

                case 2:

                    searchBooks();

                    break;

                case 3:

                    borrowBook(username);

                    break;

                case 4:

                    returnBook(username);

                    break;

                case 5:

                    libraryService.getPatronHistory(username)

                            .forEach(System.out::println);

                    break;

                case 6:

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }

    private void searchBooks() {

        System.out.print("Search By (Title/Author/Genre) : ");

        String searchBy = scanner.nextLine();

        System.out.print("Search Query : ");

        String query = scanner.nextLine();

        List<Book> books =

                libraryService.searchBooks(query, searchBy);

        if (books.isEmpty()) {

            System.out.println("No Books Found");

        } else {

            books.forEach(System.out::println);
        }
    }

    private void borrowBook(String username) {

        System.out.print("Enter Book ID : ");

        int bookId = Integer.parseInt(scanner.nextLine());

        boolean success =

                libraryService.borrowBook(username, bookId);

        if (success) {

            System.out.println("Book Borrowed Successfully");

        } else {

            System.out.println("Book Not Available");
        }
    }

    private void returnBook(String username) {

        System.out.print("Enter Book ID : ");

        int bookId = Integer.parseInt(scanner.nextLine());

        boolean success =

                libraryService.returnBook(username, bookId);

        if (success) {

            System.out.println("Book Returned Successfully");

        } else {

            System.out.println("No Active Borrowing Found");
        }
    }
}