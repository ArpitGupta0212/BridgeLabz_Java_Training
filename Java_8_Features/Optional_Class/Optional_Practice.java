import java.util.*;
public class Optional_Practice{
    public static Optional<String> getName(){
        return Optional.ofNullable("Arpit");
    }
    public static void main(String[] args) {
        String str=null;
        Optional <String> opt=Optional.ofNullable(str);
        System.out.println(opt.isPresent());
        System.out.println(opt.orElse("Nothing in String"));
        Optional<String> optionalName=getName();
        System.out.println(optionalName.orElse("Null return "));

    }
}