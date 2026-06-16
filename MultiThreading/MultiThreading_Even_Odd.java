class OddRunnable implements Runnable{
    public void run(){
        for(int i=1;i<101;i++){
            if(i%2!=0){
                System.out.println("Odd Thread"+Thread.currentThread().getName()+" "+i);
            }
        }
    }
}
class EvenRunnable implements Runnable{
    public void run(){
        for(int i=1;i<101;i++){
            if(i%2==0){
                System.out.println("Even Thread"+Thread.currentThread().getName()+" "+i);
            }
        }
    }
} 
public class MultiThreading_Even_Odd {
    public static void main(String[] args) {
        EvenRunnable e1=new EvenRunnable();
        OddRunnable o1=new OddRunnable();
        Thread t1=new Thread(e1);
        Thread t2=new Thread(o1);
        t1.start();
        t2.start();
    }   
}
