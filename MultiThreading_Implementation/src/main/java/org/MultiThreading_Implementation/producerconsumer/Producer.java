package org.MultiThreading_Implementation.producerconsumer;

public class Producer extends Thread {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 10; i++) {

                buffer.produce(i);

                Thread.sleep(300);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
