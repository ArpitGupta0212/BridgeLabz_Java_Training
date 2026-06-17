import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {
        //1 type of Stream creation 
        // Stream<Object> emptyStream=Stream.empty();
        // 2 type of Stream Creation
        String names[]={"Arpit","Shyam","Sambhav","Rudra"};
        Stream<String> s1=Stream.of(names);
        s1.forEach(e->{
            System.out.println(e);
        });
    }
}
