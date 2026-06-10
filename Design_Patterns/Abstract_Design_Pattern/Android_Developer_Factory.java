public class Android_Developer_Factory extends Employee_Abstract_Factory {
    public Employee createEmployee(){
        return new Android_Developer();
    }
}
