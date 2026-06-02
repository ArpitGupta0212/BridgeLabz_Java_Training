import java.util.*;

// Custom Exception
class ContactNotFoundException extends Exception {

    public ContactNotFoundException(String msg) {
        super(msg);
    }
}

// Contact Class
class Contact {

    int id;
    String name;
    String phone;

    public Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone;
    }
}

// Generic Class
class Storage<T> {

    private List<T> list = new ArrayList<>();

    public void add(T obj) {
        list.add(obj);
    }

    public List<T> getAll() {
        return list;
    }
}

public class AddressBook {

    static ArrayList<Contact> contacts = new ArrayList<>();

    // Generic Method
    public static <T> void print(T data) {
        System.out.println(data);
    }

    // Bounded Type Parameter
    public static <T extends Number> void show(T num) {
        System.out.println("Number : " + num);
    }

    // Wildcard
    public static void displayList(List<?> list) {

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // CREATE
    public static void addContact(Contact c) {

        contacts.add(c);
        System.out.println("Contact Added");
    }

    // RETRIEVE
    public static void displayContacts() {

        System.out.println("\nContact List:");

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    // UPDATE
    public static void updateContact(
            int id,
            String newPhone)
            throws ContactNotFoundException {

        boolean found = false;

        for (Contact c : contacts) {

            if (c.id == id) {

                c.phone = newPhone;
                found = true;
                break;
            }
        }

        if (!found) {

            throw new ContactNotFoundException(
                    "Contact Not Found");
        }

        System.out.println("Contact Updated");
    }

    // DELETE
    public static void deleteContact(int id)
            throws ContactNotFoundException {

        boolean removed = contacts.removeIf(
                c -> c.id == id);

        if (!removed) {

            throw new ContactNotFoundException(
                    "Contact Not Found");
        }

        System.out.println("Contact Deleted");
    }

    public static void main(String[] args) {

        try {

            // Generic Class
            Storage<Contact> storage = new Storage<>();

            Contact c1 = new Contact(
                    1,
                    "Arpit",
                    "9999999999");

            Contact c2 = new Contact(
                    2,
                    "Rahul",
                    "8888888888");

            storage.add(c1);
            storage.add(c2);

            // CREATE
            addContact(c1);
            addContact(c2);

            // RETRIEVE
            displayContacts();

            // UPDATE
            updateContact(
                    1,
                    "7777777777");

            displayContacts();

            // Generic Method
            print("\nGeneric Method");
            print("Hello");
            print(100);

            // Bounded Type
            show(10);
            show(20.5);

            // Wildcard
            System.out.println("\nWildcard Demo");
            displayList(contacts);

            // Stack
            Stack<String> stack = new Stack<>();

            stack.push("Java");
            stack.push("Python");

            System.out.println(
                    "\nStack : " + stack);

            // Queue
            Queue<String> queue = new LinkedList<>();

            queue.offer("A");
            queue.offer("B");

            System.out.println(
                    "Queue : " + queue);

            // Set
            Set<String> set = new HashSet<>();

            set.add("Java");
            set.add("Java");
            set.add("Python");

            System.out.println(
                    "Set : " + set);

            // Map
            Map<Integer, String> map = new HashMap<>();

            map.put(1, "Arpit");
            map.put(2, "Rahul");

            System.out.println(
                    "Map : " + map);

            // DELETE
            deleteContact(2);

            displayContacts();
        }

        catch (ContactNotFoundException e) {

            System.out.println(
                    e.getMessage());
        }

        catch (Exception e) {

            System.out.println(e);
        }

        finally {

            System.out.println(
                    "\nProgram Finished");
        }
    }
}