import java.util.*;
interface Subject{
    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    void notifyChanges();
}
interface Observer{
    void notified();
}
class Subscriber implements Observer{
    public void notified(){
        System.out.println("New Video Uploaded");
    }
}
class Youtube implements Subject{
    ArrayList<Observer> subscribers=new ArrayList<>();
    public void subscribe(Observer ob){
        this.subscribers.add(ob);
    }
    public void unsubscribe(Observer ob){
        this.subscribers.remove(ob);
    }
    public void notifyChanges(){
        for(Observer ob:this.subscribers){
            ob.notified();
        }
    }
}
public class Client{
    public static void main(String[] args) {
        Youtube yt=new Youtube();
        Subscriber Arpit=new Subscriber();
        yt.subscribe(Arpit);
        yt.notifyChanges();
    }
}