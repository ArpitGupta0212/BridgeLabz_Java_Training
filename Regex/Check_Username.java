import java.util.regex.*;

public class Check_Username {
    public static void main(String args[]){
        String str="[a-zA-z0-9@$]+";
        Pattern pt=Pattern.compile(str);
        Matcher mt=pt.matcher("arpitboss0606$");
        // Matches is used for exact same
        System.out.println(mt.matches());
    }
}
