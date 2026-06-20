package com.Hotel_Reservation_System.threads;

import com.Hotel_Reservation_System.model.Reservation;

public class PaymentProcessor extends Thread {

    private final Reservation reservation;
    private final Object lock;

    public PaymentProcessor(Reservation reservation, Object lock) {

        this.reservation = reservation;
        this.lock = lock;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(150);

            synchronized (lock) {

                lock.wait();

                reservation.setStatus("Paid");

                System.out.println(reservation.getReservationId() + " Payment Success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
