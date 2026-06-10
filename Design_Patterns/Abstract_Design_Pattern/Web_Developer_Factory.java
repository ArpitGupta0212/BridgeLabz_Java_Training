public class Web_Developer_Factory extends Employee_Abstract_Factory {

    public Employee createEmployee(){
        return new Web_Developer();
    }

}
