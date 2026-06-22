import java.util.ArrayList;
import java.util.List;

public class TicketBookingSystem {

    private static int availableSeats = 20;

    private static final List<String> history =
            new ArrayList<>();

    static synchronized void book(
            String customer,
            int seats) {

        if (availableSeats >= seats) {

            availableSeats -= seats;

            history.add(customer +
                    " booked " + seats);

            System.out.println(
                    customer +
                    " Booking Success");
        }
        else {

            System.out.println(
                    customer +
                    " Booking Failed");
        }
    }

    public static void main(String[] args)
            throws Exception {

        Thread c1 =
                new Thread(() ->
                        book("Arpit", 5));

        Thread c2 =
                new Thread(() ->
                        book("Rahul", 8));

        Thread c3 =
                new Thread(() ->
                        book("Amit", 10));

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println("\nHistory");

        history.forEach(System.out::println);

        System.out.println(
                "Available Seats = "
                        + availableSeats);
    }
}