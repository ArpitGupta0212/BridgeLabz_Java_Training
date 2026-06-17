import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StreamApi_Practice{
    public static void main(String args[]){
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(2);
        list1.add(10);
        list1.add(6);
        list1.add(5);

        List<Integer> evenList=list1.stream().filter((i)->{
            return i%2==0;}).collect(Collectors.toList());
        System.out.println(evenList);
        List<Integer> list2=list1.stream().filter((i)->{
            return i>4;
        }).collect(Collectors.toList());
        System.out.println(list2);
    }
}