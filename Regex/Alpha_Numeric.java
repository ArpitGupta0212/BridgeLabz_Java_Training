import java.util.regex.*;


public class Alpha_Numeric {
    public static void main(String args[]){
        String str="a*b";
        Pattern pt=Pattern.compile(str);
        Matcher mt=pt.matcher("acb");
        // Matches is used for exact same
        System.out.println(mt.matches());
    }
}
