package com.LibraryManagementSystem.model;

import java.util.Objects;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private int quantity;
    private double price;

    public Book() {
    }

    public Book(int bookId, String title, String author, String genre, String isbn, int quantity, double price) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "Book{" + "bookId=" + bookId + ", title='" + title + '\'' + ", author='" + author + '\'' + ", genre='" + genre + '\'' + ", isbn='" + isbn + '\'' + ", quantity=" + quantity + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Book book)) return false;

        return bookId == book.bookId || isbn.equalsIgnoreCase(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn);
    }
}