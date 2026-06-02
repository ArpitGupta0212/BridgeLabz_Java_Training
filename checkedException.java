import java.io.FileReader;
import java.util.*;

public class checkedException{
    public static void main(String[] args) {
        int a=6;
        int b=0;
        try{
            System.out.println("Try Blck");
            FileReader fr = new FileReader("abc.txt");
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Final Block");
        }
    }
}