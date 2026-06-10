public class Employee_Factory {
    public static Employees getEmployee(String emptype){
        if(emptype.trim().equalsIgnoreCase("Android Developer")){
            return new Android_Developer();
        }
        else if(emptype.trim().equalsIgnoreCase("Web Developer")){
            return new Web_Developer();
        }else{
            return null;
        }
    }
}
