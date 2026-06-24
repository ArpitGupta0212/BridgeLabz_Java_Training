package com.LibraryManagementSystem.threads;

import com.LibraryManagementSystem.model.Transaction;

public class ThreadStateTracker {

    public static void demonstrateLifecycle() {

        try {

            // Step 1
            Object lock = new Object();

            Transaction transaction = new Transaction("TXN001", "arpit", 1, "2026-06-20", "2026-06-27", "Borrowed");

            // Step 2
            FineCalculator t = new FineCalculator(transaction, lock);

            System.out.println("NEW : " + t.getState());

            // Step 3
            t.start();

            System.out.println("RUNNABLE : " + t.getState());

            // Step 4
            Thread.sleep(50);

            System.out.println("TIMED_WAITING : " + t.getState());

            // Step 5
            synchronized (lock) {

                Thread.sleep(200);

                // Step 6
                System.out.println("WAITING : " + t.getState());

                // Step 7
                lock.notify();

                System.out.println("After Notify : " + t.getState());

                Thread.sleep(100);

                System.out.println("BLOCKED : " + t.getState());
            }

            // Step 8
            t.join();

            System.out.println("TERMINATED : " + t.getState());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}