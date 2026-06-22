package com.LibraryManagementSystem.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentBorrowSimulator {

    public static void runTest() {

        try (ExecutorService ex = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 1000; i++) {

                int id = i;

                ex.submit(() -> {

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    System.out.println("Borrow Request " + id + " : " + Thread.currentThread());

                });
            }
        }catch (Exception e){

        }
    }
}
