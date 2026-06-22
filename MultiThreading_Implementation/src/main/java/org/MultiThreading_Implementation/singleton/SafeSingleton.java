package org.MultiThreading_Implementation.singleton;


public class SafeSingleton {

    private static volatile SafeSingleton instance;

    private SafeSingleton() {
    }

    public static synchronized SafeSingleton getInstance() {

        if (instance == null) {

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }

            instance = new SafeSingleton();
        }

        return instance;
    }
}
