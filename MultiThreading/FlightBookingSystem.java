import java.util.ArrayList;
import java.util.List;

public class FlightBookingSystem {

    static class BookingTask
            implements Runnable {

        private final int bookingId;

        public BookingTask(int bookingId) {
            this.bookingId = bookingId;
        }

        @Override
        public void run() {

            try {

                System.out.println(
                        "Booking " + bookingId
                                + " Validation");

                Thread.sleep(100);

                System.out.println(
                        "Booking " + bookingId
                                + " Seat Check");

                Thread.sleep(100);

                System.out.println(
                        "Booking " + bookingId
                                + " Payment");

                Thread.sleep(100);

                System.out.println(
                        "Booking " + bookingId
                                + " Ticket Generated");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        long start =
                System.currentTimeMillis();

        List<Thread> threads =
                new ArrayList<>();

        for (int i = 1;
             i <= 10000;
             i++) {

            Thread t =
                    Thread.ofVirtual()
                            .start(
                                    new BookingTask(i));

            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        long end =
                System.currentTimeMillis();

        System.out.println(
                "\nTotal Time : "
                        + (end - start)
                        + " ms");
    }
}