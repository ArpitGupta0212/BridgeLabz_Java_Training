public class ParallelNumberPrinter {

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

    static class NumberRunnable implements Runnable {

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
        t1.setName("Thread-1");

        Thread t2 = new Thread(
                new NumberRunnable());

        t2.setName("Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "Both Threads Completed");
    }
}