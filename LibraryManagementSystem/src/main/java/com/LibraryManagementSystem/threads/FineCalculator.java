package com.LibraryManagementSystem.threads;

import com.LibraryManagementSystem.model.Transaction;

public class FineCalculator extends Thread {

    private final Transaction transaction;
    private final Object lock;

    public FineCalculator(Transaction transaction, Object lock) {

        this.transaction = transaction;
        this.lock = lock;
    }

    @Override
    public void run() {

        try {

            // TIMED_WAITING State
            Thread.sleep(150);

            synchronized (lock) {

                // WAITING State
                lock.wait();

                // Fine Calculation
                transaction.setFine(5.0);

                // Status Update
                transaction.setStatus("Overdue");

                System.out.println("Fine Calculated for : " + transaction.getTransactionId());

                System.out.println("Fine Amount : " + transaction.getFine());

                System.out.println("Status : " + transaction.getStatus());
            }

        } catch (InterruptedException e) {

            System.out.println("Thread Interrupted");

            e.printStackTrace();
        }
    }
}