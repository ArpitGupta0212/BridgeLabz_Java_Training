class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Thread Using Runnable");
        System.out.println(Thread.currentThread().getName());
        // System.out.println(Thread.currentThread().getId());
    }
}
public class MultiThreading_Practice_Using_Interface {
    public static void main(String[] args) {
    MyRunnable r1=new MyRunnable();
    Thread t1=new Thread(r1);
    t1.start();   
    Thread t2=new Thread(r1);
    t2.start();
    System.out.println(Thread.currentThread().getName());
    }
}
