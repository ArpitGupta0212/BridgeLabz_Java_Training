interface myinterface{
    void sayhello();
}
interface Sum{
    int add(int a, int b);
}
interface LengthString{

    int getLength(String str);
}
public class Lambda_Practice{
    public static void main(String[] args) {
        myinterface inter=()->{
            System.out.println("Lamda 1");
        };
        inter.sayhello();
        Sum ans=(a,b)-> {
          return a+b;  
        };
        System.out.println(ans.add(4,9));
        LengthString str1=(str)-> str.length();
        System.out.println(str1.getLength("Arpit"));
    }
}