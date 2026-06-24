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
        this.fine = 0.0;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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

        return "Transaction{" + "transactionId='" + transactionId + '\'' + ", patronName='" + patronName + '\'' + ", bookId=" + bookId + ", borrowDate='" + borrowDate + '\'' + ", dueDate='" + dueDate + '\'' + ", status='" + status + '\'' + ", fine=" + fine + '}';
    }
}