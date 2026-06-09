class Bird {
    public void eat() {
        System.out.println("Birds Eating");
    }
}
class Spparow extends Bird{
    public void eat(){
        System.out.println("Sparrow Eating");
    }
} 

public class Lsp {
    public static void main(String[] args) {
        // Liskov Substtution principle
        Bird bird=new Spparow();
        bird.eat();
    }
}
