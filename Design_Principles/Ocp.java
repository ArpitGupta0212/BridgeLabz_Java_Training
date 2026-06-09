
    interface Payment {
        void pay();
    }
    class Upi implements Payment{
        public void pay(){
            System.out.println("Successfully Payment by upi");
        }
    }
    class Card implements Payment{
        public void pay(){
            System.out.println("Successfully Payment by card");
        }
    }
    public class Ocp {
    public static void main(String[] args) {
        Payment pa=new Upi();
        pa.pay();
    }
}
