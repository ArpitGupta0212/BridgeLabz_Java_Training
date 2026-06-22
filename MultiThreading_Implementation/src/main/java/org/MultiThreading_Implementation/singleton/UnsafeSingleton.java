package org.MultiThreading_Implementation.singleton;

public class UnsafeSingleton {

    private static UnsafeSingleton instance;

    private UnsafeSingleton() {
    }

    public static UnsafeSingleton getInstance() {

        if (instance == null) {

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }

            instance = new UnsafeSingleton();
        }

        return instance;
    }
}
