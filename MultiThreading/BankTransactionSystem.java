public class BankTransactionSystem {

    private static int balance = 10000;

    static synchronized void deposit(int amount) {

        balance += amount;

        System.out.println(
                Thread.currentThread().getName()
                        + " Deposited ₹" + amount);
    }

    static synchronized void withdraw(int amount) {

        balance -= amount;

        System.out.println(
                Thread.currentThread().getName()
                        + " Withdraw " + amount);
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 5; i++) {

            threads[i] = new Thread(() ->
                    deposit(1000),
                    "Deposit-" + (i + 1));
        }

        for (int i = 5; i < 10; i++) {

            threads[i] = new Thread(() ->
                    withdraw(500),
                    "Withdraw-" + (i - 4));
        }

        for (Thread t : threads)
            t.start();

        for (Thread t : threads)
            t.join();

        System.out.println(
                "\nFinal Balance = ₹" + balance);
    }
}