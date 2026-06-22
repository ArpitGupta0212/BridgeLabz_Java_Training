package com.LibraryManagementSystem.model;

public class Transaction {

    private String transactionId;
    private String patronName;
    private int bookId;
    private String borrowDate;
    private String dueDate;
    private String status;
    private double fine;

    public Transaction() {
    }

    public Transaction(String transactionId, String patronName, int bookId, String borrowDate, String dueDate, String status) {

        this.transactionId = transactionId;
        this.patronName = patronName;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPatronName() {
        return patronName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return transactionId + " | " + patronName + " | " + status;
    }
}