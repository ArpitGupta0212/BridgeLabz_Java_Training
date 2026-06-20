package com.Hotel_Reservation_System.threads;

import com.Hotel_Reservation_System.model.Reservation;

public class NotificationDispatcher implements Runnable {

    private final Reservation reservation;

    public NotificationDispatcher(Reservation reservation) {

        this.reservation = reservation;
    }

    @Override
    public void run() {

        System.out.println("Email Sent To : " + reservation.getGuestName());

        reservation.setStatus("Confirmed");
    }
}
