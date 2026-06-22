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

            Thread.sleep(150);

            synchronized (lock) {

                lock.wait();

                transaction.setFine(5);

                transaction.setStatus("Overdue");
            }

        } catch (Exception e) {
        }
    }
}
