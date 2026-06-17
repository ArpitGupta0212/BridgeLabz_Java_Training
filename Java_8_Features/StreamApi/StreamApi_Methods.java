import java.util.List;
import java.util.stream.Collectors;

public class StreamApi_Methods {
    public static void main(String[] args) {
        // filter(Predicate)
        // predicate take boolean value function
        List<String>li=List.of("Aman", "Durgesh","GhanShyam");
        List<String> li1=li.stream().filter((e)->{
            if(e.charAt(0)=='A'){
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(li1);
        // map (FUnction)
        // each emenet operation
        List<Integer> listNum=List.of(1,3,4,5,5,6,7,7,74,3,32,5);
        List<Integer> ans=listNum.stream().map(e->{
            return e*e;
        }).collect(Collectors.toList());
        System.out.println(ans);
        listNum.stream().sorted().forEach(System.out::println);
        int min=listNum.stream().min((x,y)->x.compareTo(y)).get();
        System.out.print(min);
        int max=listNum.stream().max((x,y)->x.compareTo(y)).get();
        System.out.print(max);
    }
}
