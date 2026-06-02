import java.util.regex.*;


public class Alpha_Numeric {
    public static void main(String args[]){
        String str="[a-zA-Z0-9#]*";
        Pattern pt=Pattern.compile(str);
        Matcher mt=pt.matcher("68#47C");
        // Matches is used for exact same
        System.out.println(mt.matches());
    }
}
