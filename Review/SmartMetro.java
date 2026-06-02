import java.util.*;

class Passenger {

    private int id;
    private String name;
    private int age;
    private String source;
    private String destination;
    private double balance;

    public Passenger(int id, String name, int age,
            String source, String destination,
            double balance) {

        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");

        this.id = id;
        this.name = name;
        this.age = age;
        this.source = source;
        this.destination = destination;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void display() {

        System.out.println(
                "ID: " + id +
                        " Name: " + name +
                        " Age: " + age +
                        " Source: " + source +
                        " Destination: " + destination +
                        " Balance: " + balance);
    }
}

class Node {

    Passenger data;
    Node next;

    Node(Passenger data) {
        this.data = data;
    }
}

public class SmartMetro {

    static ArrayList<Passenger> passengers = new ArrayList<>();

    static Queue<Passenger> bookingQueue = new LinkedList<>();

    static Stack<String> stationHistory = new Stack<>();

    static HashMap<String, Integer> stationCount = new HashMap<>();

    static HashMap<String, Integer> routeCount = new HashMap<>();

    static Node head = null;
    static Node tail = null;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SMART METRO SYSTEM =====");
            System.out.println("1. Add Passenger");
            System.out.println("2. Remove Passenger");
            System.out.println("3. Update Passenger");
            System.out.println("4. Search Passenger");
            System.out.println("5. Display All Passengers");
            System.out.println("6. Ticket Booking Queue");
            System.out.println("7. Recent Stations Stack");
            System.out.println("8. Analytics");
            System.out.println("9. Circular Route");
            System.out.println("10. Sort By Age");
            System.out.println("11. Sort By Balance");
            System.out.println("12. Binary Search By ID");
            System.out.println("13. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPassenger();
                    break;

                case 2:
                    removePassenger();
                    break;

                case 3:
                    updatePassenger();
                    break;

                case 4:
                    searchPassenger();
                    break;

                case 5:
                    displayPassengers();
                    break;

                case 6:
                    queueMenu();
                    break;

                case 7:
                    stackMenu();
                    break;

                case 8:
                    analytics();
                    break;

                case 9:
                    circularMenu();
                    break;

                case 10:
                    bubbleSortAge();
                    break;

                case 11:
                    insertionSortBalance();
                    break;

                case 12:
                    binarySearch();
                    break;

                case 13:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addPassenger() {

        try {

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Passenger p : passengers) {
                if (p.getId() == id) {
                    System.out.println("ID Already Exists");
                    return;
                }
            }

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Source: ");
            String source = sc.nextLine();

            System.out.print("Destination: ");
            String destination = sc.nextLine();

            System.out.print("Balance: ");
            double balance = sc.nextDouble();

            Passenger p = new Passenger(
                    id, name, age,
                    source, destination,
                    balance);

            passengers.add(p);

            System.out.println("Passenger Added");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    static void removePassenger() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        passengers.removeIf(p -> p.getId() == id);

        System.out.println("Passenger Removed");
    }

    static void updatePassenger() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Passenger p : passengers) {

            if (p.getId() == id) {

                System.out.print("New Name: ");
                p.setName(sc.nextLine());

                System.out.print("New Age: ");
                p.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("New Source: ");
                p.setSource(sc.nextLine());

                System.out.print("New Destination: ");
                p.setDestination(sc.nextLine());

                System.out.print("New Balance: ");
                p.setBalance(sc.nextDouble());

                System.out.println("Updated");
                return;
            }
        }

        System.out.println("Passenger Not Found");
    }

    static void searchPassenger() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Passenger p : passengers) {

            if (p.getId() == id) {
                p.display();
                return;
            }
        }

        System.out.println("Not Found");
    }

    static void displayPassengers() {

        for (Passenger p : passengers) {
            p.display();
        }
    }

    static void queueMenu() {

        System.out.println("1.Add Booking");
        System.out.println("2.Process Booking");
        System.out.println("3.Next Booking");
        System.out.println("4.Display Queue");

        int ch = sc.nextInt();

        switch (ch) {

            case 1:

                System.out.print("Passenger ID: ");
                int id = sc.nextInt();

                for (Passenger p : passengers) {
                    if (p.getId() == id) {
                        bookingQueue.offer(p);
                    }
                }

                break;

            case 2:

                Passenger processed = bookingQueue.poll();

                if (processed != null)
                    processed.display();

                break;

            case 3:

                Passenger next = bookingQueue.peek();

                if (next != null)
                    next.display();

                break;

            case 4:

                for (Passenger p : bookingQueue)
                    p.display();
        }
    }

    static void stackMenu() {

        System.out.println("1.Add Station");
        System.out.println("2.Undo");
        System.out.println("3.Display History");

        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {

            case 1:

                System.out.print("Station Name: ");
                stationHistory.push(sc.nextLine());
                break;

            case 2:

                if (!stationHistory.isEmpty())
                    System.out.println(
                            "Removed: "
                                    + stationHistory.pop());

                break;

            case 3:

                System.out.println(stationHistory);
        }
    }

    static void analytics() {

        stationCount.clear();
        routeCount.clear();

        for (Passenger p : passengers) {

            stationCount.put(
                    p.getSource(),
                    stationCount.getOrDefault(
                            p.getSource(), 0) + 1);

            String route = p.getSource() + " -> "
                    + p.getDestination();

            routeCount.put(
                    route,
                    routeCount.getOrDefault(
                            route, 0) + 1);
        }

        System.out.println("Passenger Per Station");

        for (String s : stationCount.keySet()) {

            System.out.println(
                    s + " : "
                            + stationCount.get(s));
        }

        int max = 0;
        String popular = "";

        for (String r : routeCount.keySet()) {

            if (routeCount.get(r) > max) {

                max = routeCount.get(r);
                popular = r;
            }
        }

        System.out.println(
                "Most Visited Route: "
                        + popular +
                        " Count = " + max);
    }

    static void circularMenu() {

        System.out.println("1.Add Passenger");
        System.out.println("2.Display Route");

        int ch = sc.nextInt();

        switch (ch) {

            case 1:

                System.out.print("Passenger ID: ");
                int id = sc.nextInt();

                for (Passenger p : passengers) {

                    if (p.getId() == id) {

                        Node newNode = new Node(p);

                        if (head == null) {

                            head = tail = newNode;
                            tail.next = head;

                        } else {

                            tail.next = newNode;
                            tail = newNode;
                            tail.next = head;
                        }
                    }
                }

                break;

            case 2:

                if (head == null) {
                    System.out.println("Empty");
                    return;
                }

                Node temp = head;

                do {

                    temp.data.display();

                    temp = temp.next;

                } while (temp != head);

                break;
        }
    }

    static void bubbleSortAge() {

        for (int i = 0; i < passengers.size() - 1; i++) {

            for (int j = 0; j < passengers.size() - i - 1; j++) {

                if (passengers.get(j).getAge() > passengers.get(j + 1)
                        .getAge()) {

                    Passenger temp = passengers.get(j);

                    passengers.set(
                            j,
                            passengers.get(j + 1));

                    passengers.set(
                            j + 1,
                            temp);
                }
            }
        }

        displayPassengers();
    }

    static void insertionSortBalance() {

        for (int i = 1; i < passengers.size(); i++) {

            Passenger key = passengers.get(i);

            int j = i - 1;

            while (j >= 0 &&
                    passengers.get(j)
                            .getBalance() > key.getBalance()) {

                passengers.set(
                        j + 1,
                        passengers.get(j));

                j--;
            }

            passengers.set(j + 1, key);
        }

        displayPassengers();
    }

    static void binarySearch() {

        passengers.sort(
                Comparator.comparingInt(
                        Passenger::getId));

        System.out.print("Enter ID: ");
        int target = sc.nextInt();

        int low = 0;
        int high = passengers.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (passengers.get(mid)
                    .getId() == target) {

                passengers.get(mid)
                        .display();

                return;
            }

            else if (passengers.get(mid)
                    .getId() < target) {

                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }

        System.out.println("Not Found");
    }
}