import java.util.regex.*;

public class Check_Email_Address {
public static void main(String args[]){
        String str="^[a-zA-Z0-9_.$-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}\\.[a-zA-Z]{2,}$";
        Pattern pt=Pattern.compile(str);
        Matcher mt=pt.matcher("arpitboss52525@gmail.com.in");
        // Matches is used for exact same
        System.out.println(mt.matches());
    }
}
