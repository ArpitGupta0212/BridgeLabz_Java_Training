interface Workable{
    void work();
}
interface Eatable{
    void eat();
}
class Robot implements Workable, Eatable{
    public void work(){
        System.out.println("Robot is Working");
    }
    public void eat(){
        System.out.println("Robot is Eating");
    }
}
public class Isp {
    public static void main(String[] args) {
        // Interface Segregation Principle
        Robot ro=new Robot();
        ro.eat();
    }
}
