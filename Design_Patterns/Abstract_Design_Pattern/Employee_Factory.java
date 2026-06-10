public class Employee_Factory {
    public static Employee getEmployee(Employee_Abstract_Factory factory ){
        return factory.createEmployee();
    }
}
