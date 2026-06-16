public class MultiThreading_Practice_Using_Thread_ClaSS{    
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();
        
    }
}
class MyThread extends Thread{
        public void run(){
            System.out.println("Your Thread Is Running");
        }
    }