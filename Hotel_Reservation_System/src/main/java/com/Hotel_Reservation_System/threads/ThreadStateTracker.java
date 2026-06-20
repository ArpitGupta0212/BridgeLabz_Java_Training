package com.Hotel_Reservation_System.threads;

import com.Hotel_Reservation_System.model.Reservation;

public class ThreadStateTracker {

    public static void demonstrateLifecycle() throws Exception {

        Object lock = new Object();

        Reservation reservation = new Reservation("RES-1", "Arpit", 101, 2, 400, "Pending");

        PaymentProcessor t = new PaymentProcessor(reservation, lock);

        System.out.println("NEW : " + t.getState());

        t.start();

        Thread.sleep(50);

        System.out.println("TIMED_WAITING : " + t.getState());

        Thread.sleep(200);

        synchronized (lock) {

            System.out.println("WAITING : " + t.getState());

            lock.notify();

            System.out.println("BLOCKED : " + t.getState());

            Thread.sleep(100);
        }

        t.join();

        System.out.println("TERMINATED : " + t.getState());
    }
}
