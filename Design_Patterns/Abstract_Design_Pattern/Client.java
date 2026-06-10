public class Client {
    public static void main(String[] args) {
        Employee e=Employee_Factory.getEmployee(new Web_Developer_Factory());
        System.out.println(e.name());
    }
}
