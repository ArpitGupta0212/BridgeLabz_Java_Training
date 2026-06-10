public class Developer_Client {
    public static void main(String[] args) {
    Employees emp=Employee_Factory.getEmployee("android developer");
    System.out.println(emp.salary());        
    }

}
