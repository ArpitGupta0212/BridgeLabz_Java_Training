package org.MultiThreading_Implementation;


import org.MultiThreading_Implementation.lifecycle.ThreadStateDemo;
import org.MultiThreading_Implementation.producerconsumer.ProducerConsumerDemo;
import org.MultiThreading_Implementation.singleton.SingletonConcurrencyDemo;

public class Main {

    public static void main(String[] args)
            throws Exception {

        System.out.println("===============");
        System.out.println("THREAD STATES");
        System.out.println("===============");

        ThreadStateDemo.demonstrateStates();

        System.out.println("\n======================");
        System.out.println("PRODUCER CONSUMER");
        System.out.println("======================");

        ProducerConsumerDemo.runTraditionalDemo();

        System.out.println("\n======================");
        System.out.println("VIRTUAL THREADS");
        System.out.println("======================");

        ProducerConsumerDemo.runVirtualThreadDemo();

        System.out.println("\n======================");
        System.out.println("SINGLETON TEST");
        System.out.println("======================");

        SingletonConcurrencyDemo.runDemo();
    }
}