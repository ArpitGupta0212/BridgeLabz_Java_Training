package org.MultiThreading_Implementation.singleton;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonConcurrencyDemo {

    public static void runDemo()
            throws InterruptedException {

        Set<Integer> unsafeSet =
                ConcurrentHashMap.newKeySet();

        Thread[] unsafeThreads = new Thread[50];

        for (int i = 0; i < 50; i++) {

            unsafeThreads[i] = new Thread(() -> {

                unsafeSet.add(
                        System.identityHashCode(
                                UnsafeSingleton.getInstance()));
            });

            unsafeThreads[i].start();
        }

        for (Thread t : unsafeThreads) {
            t.join();
        }

        System.out.println(
                "Unsafe Singleton Instances = "
                        + unsafeSet.size());

        Set<Integer> safeSet =
                ConcurrentHashMap.newKeySet();

        Thread[] safeThreads = new Thread[50];

        for (int i = 0; i < 50; i++) {

            safeThreads[i] = new Thread(() -> {

                safeSet.add(
                        System.identityHashCode(
                                SafeSingleton.getInstance()));
            });

            safeThreads[i].start();
        }

        for (Thread t : safeThreads) {
            t.join();
        }

        System.out.println(
                "Safe Singleton Instances = "
                        + safeSet.size());
    }
}
