public class SmartNumberPrinter {

    static class NumberThread extends Thread {

        @Override
        public void run() {

            for (int i = 1; i <= 50; i++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " : " + i);
            }
        }
    }

    static class NumberRunnable
            implements Runnable {

        @Override
        public void run() {

            for (int i = 51; i <= 100; i++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " : " + i);
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread t1 = new NumberThread();

        Thread t2 = new Thread(
                new NumberRunnable());

        Thread t3 = new Thread(() -> {

            for (char ch = 'A';
                 ch <= 'Z';
                 ch++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " : " + ch);
            }
        });

        t1.setName("Thread-A");
        t2.setName("Thread-B");
        t3.setName("Thread-C");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(
                "All Threads Completed");
    }
}