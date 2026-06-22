package org.MultiThreading_Implementation.producerconsumer;

public class ProducerConsumerDemo {

    public static void runTraditionalDemo()
            throws InterruptedException {

        System.out.println("\nTraditional Threads\n");

        Buffer buffer = new Buffer(5);

        Producer producer = new Producer(buffer);

        Thread consumer =
                new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    public static void runVirtualThreadDemo()
            throws InterruptedException {

        System.out.println("\nVirtual Threads\n");

        Buffer buffer = new Buffer(5);

        Thread producer =
                Thread.ofVirtual().start(() -> {

                    try {

                        for (int i = 1; i <= 10; i++) {

                            buffer.produce(i);

                            Thread.sleep(200);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        Thread consumer =
                Thread.ofVirtual().start(() -> {

                    try {

                        for (int i = 1; i <= 10; i++) {

                            buffer.consume();

                            Thread.sleep(400);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        producer.join();
        consumer.join();
    }
}