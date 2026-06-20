package com.Hotel_Reservation_System.threads;

import com.Hotel_Reservation_System.io.FileOperations;
import com.Hotel_Reservation_System.model.Reservation;
import com.Hotel_Reservation_System.service.ReservationService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadSimulator {

    public static void runHighConcurrencyTest(ReservationService service, List<Reservation> requests) {

        long start = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (Reservation reservation : requests) {

                executor.submit(() -> {

                    FileOperations.writeReceipt("receipt_" + reservation.getReservationId() + ".txt",

                            reservation.toString());
                });
            }

        }

        long end = System.currentTimeMillis();

        System.out.println("Processed " + requests.size() + " requests in " + (end - start) + " ms");
    }
}
