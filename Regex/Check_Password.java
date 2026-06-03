import java.util.regex.*;

public class Check_Password {
    public static void main(String args[]){
        String str="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&+=]).{11,}$";
        Pattern pt=Pattern.compile(str);
        Matcher mt=pt.matcher("@Rpit06604");
        // Matches is used for exact same
        System.out.println(mt.matches());
    }
}
