import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThread{
    public static void main(String args[]){
        ExecutorService ex=Executors.newVirtualThreadPerTaskExecutor();
        for(int i=0;i<10;i++){
            ex.submit(()->{
                System.out.println(Thread.currentThread());
            });
        }
        try{
            Thread.sleep(4000);
        }
        catch(Exception e){}
    }
}