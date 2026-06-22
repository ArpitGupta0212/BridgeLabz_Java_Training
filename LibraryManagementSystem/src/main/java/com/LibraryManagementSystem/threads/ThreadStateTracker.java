package com.LibraryManagementSystem.threads;

import com.LibraryManagementSystem.model.Transaction;

public class ThreadStateTracker {

    public static void demonstrateLifecycle() {

        try {

            Object lock = new Object();

            Transaction transaction = new Transaction("TXN-101", "Arpit", 1, "2026-06-20", "2026-06-27", "Borrowed");

            FineCalculator t = new FineCalculator(transaction, lock);

            System.out.println("NEW : " + t.getState());

            t.start();

            System.out.println("RUNNABLE : " + t.getState());

            Thread.sleep(50);

            System.out.println("TIMED_WAITING : " + t.getState());

            synchronized (lock) {

                Thread.sleep(200);


                System.out.println("WAITING : " + t.getState());


                lock.notify();

                System.out.println("After notify : " + t.getState());

                Thread.sleep(100);

                System.out.println("BLOCKED : " + t.getState());
            }


            t.join();

            System.out.println("TERMINATED : " + t.getState());

        } catch (Exception e) {
        }
    }
}
