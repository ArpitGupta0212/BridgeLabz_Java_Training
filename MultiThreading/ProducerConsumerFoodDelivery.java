import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerFoodDelivery {

    private static final Queue<Integer> orders =
            new LinkedList<>();

    private static final int CAPACITY = 5;

    static class Producer extends Thread {

        @Override
        public void run() {

            for (int i = 101; i <= 110; i++) {

                synchronized (orders) {

                    try {

                        while (orders.size() == CAPACITY) {
                            orders.wait();
                        }

                        orders.add(i);

                        System.out.println(
                                "Order Prepared : #" + i);

                        orders.notifyAll();

                        Thread.sleep(500);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer extends Thread {

        @Override
        public void run() {

            for (int i = 101; i <= 110; i++) {

                synchronized (orders) {

                    try {

                        while (orders.isEmpty()) {
                            orders.wait();
                        }

                        int order = orders.poll();

                        System.out.println(
                                "Order Delivered : #" + order);

                        orders.notifyAll();

                        Thread.sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All Orders Processed");
    }
}