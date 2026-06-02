public class CustomException {
    static class InvalidAge extends Exception{
        InvalidAge(String msg){
            super(msg);
        }
    }
    static void check(int age) throws InvalidAge{
        if(age<18){
            throw new InvalidAge("Age is must above 18");
        }
            System.out.println("Valid Agee");
    }
    public static void main(String[] args) {
        int age=15;

        try{
            check(age);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Final Blck");
        }
    }
}
