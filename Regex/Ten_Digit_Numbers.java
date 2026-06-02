import java.util.regex.*;

public class Ten_Digit_Numbers {
    public static void main(String args[]){
        String str="[0-9]{10}";
        Pattern pt=Pattern.compile(str);
        Matcher mt=pt.matcher("7668598");
        // Matches is used for exact same
        System.out.println(mt.matches());
    }
}
