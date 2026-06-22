package org.MultiThreading_Implementation.lifecycle;

public class ThreadStateDemo {

    private static final Object waitLock = new Object();
    private static final Object blockLock = new Object();

    public static void demonstrateStates() throws Exception {

        Thread t = new Thread(() -> {

            try {

                Thread.sleep(100);

                synchronized (waitLock) {
                    waitLock.wait();
                }

                synchronized (blockLock) {
                    System.out.println("Thread acquired blockLock");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("NEW : " + t.getState());

        t.start();

        System.out.println("RUNNABLE : " + t.getState());

        Thread.sleep(50);
        System.out.println("TIMED_WAITING : " + t.getState());

        Thread.sleep(100);

        System.out.println("WAITING : " + t.getState());

        synchronized (blockLock) {

            synchronized (waitLock) {
                waitLock.notify();
            }

            Thread.sleep(100);

            System.out.println("BLOCKED : " + t.getState());
        }

        t.join();

        System.out.println("TERMINATED : " + t.getState());
    }
}
