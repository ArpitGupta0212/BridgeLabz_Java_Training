package com.Hotel_Reservation_System;

import com.Hotel_Reservation_System.io.CsvHandler;
import com.Hotel_Reservation_System.io.JsonHandler;
import com.Hotel_Reservation_System.model.Reservation;
import com.Hotel_Reservation_System.model.Room;
import com.Hotel_Reservation_System.service.ReservationService;
import com.Hotel_Reservation_System.threads.NotificationDispatcher;
import com.Hotel_Reservation_System.threads.ThreadStateTracker;
import com.Hotel_Reservation_System.threads.VirtualThreadSimulator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Room> rooms = CsvHandler.readRoomsFromCsv("src/main/resources/rooms.csv");

        System.out.println("Valid Rooms Loaded : " + rooms.size());

        boolean valid = JsonHandler.validateJsonSchema("src/main/resources/bookings.json", "src/main/resources/booking-schema.json");

        System.out.println("Schema Valid : " + valid);

        List<Reservation> reservations = JsonHandler.readReservationsFromJson("src/main/resources/bookings.json");

        ReservationService service = new ReservationService();

        service.loadRooms(rooms);

        reservations.forEach(r -> service.addBooking("2026-06-19", r));

        ThreadStateTracker.demonstrateLifecycle();

        if (!reservations.isEmpty()) {

            Thread notificationThread = new Thread(new NotificationDispatcher(reservations.get(0)));

            notificationThread.start();

            notificationThread.join();
        }

        List<Reservation> stressTest = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {

            stressTest.add(new Reservation("VT-" + i, "Guest-" + i, 101, 1, 100, "Pending"));
        }

        VirtualThreadSimulator.runHighConcurrencyTest(service, stressTest);

        for (Reservation r : reservations) {
            service.trackRevenue("General", r.getTotalAmount());
        }
        System.out.println("Total Revenue : " + service.calculateTotalRevenue());
    }
}
