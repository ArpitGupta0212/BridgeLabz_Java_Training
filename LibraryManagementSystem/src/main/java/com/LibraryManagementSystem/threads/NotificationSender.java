package com.LibraryManagementSystem.threads;

public class NotificationSender implements Runnable {

    private final String email;
    private final String message;

    public NotificationSender(String email, String message) {

        this.email = email;
        this.message = message;
    }

    @Override
    public void run() {

        System.out.println("Sending email to " + email);

    }
}
