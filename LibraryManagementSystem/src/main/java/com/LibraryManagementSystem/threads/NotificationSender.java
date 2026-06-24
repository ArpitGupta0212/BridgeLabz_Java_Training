package com.LibraryManagementSystem.threads;

public class NotificationSender implements Runnable {

    private final String patronEmail;
    private final String message;

    public NotificationSender(String patronEmail, String message) {

        this.patronEmail = patronEmail;

        this.message = message;
    }

    @Override
    public void run() {

        System.out.println("\nNotification Service Started");

        System.out.println("Sending Email To : " + patronEmail);

        System.out.println("Message : " + message);

        System.out.println("Email Sent Successfully");
    }
}