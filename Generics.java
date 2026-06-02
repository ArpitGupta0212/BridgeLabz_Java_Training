

public class Generics{
    static class Box<T>{
        T data;
        void SetValue(T data){
            this.data=data;
        }
        T getValue(){
            return data;
        }
    }
    static class Calculator<T extends Integer>{
        T data;
        void setValue(T data ){
            this.data=data;
        }
        T getValue(){
            return data;
        }
    }
    static class Box1{
        <T> void Show(T data){
            System.out.println(data);
        }
    }
    static class pair<K,V>{
        K key;
        V value;
        void setData(K key, V value){
            this.key=key;
            this.value=value;
        }
        
    }
    public static void main(String[] args) {
        Box<Integer> b1=new Box<>();
        Box<String> b2=new Box<>();
        Calculator<Integer> calci=new Calculator<>();
        calci.setValue(5);
        calci.getValue();
        b1.SetValue(102);
        b2.SetValue("Arpit");
        System.out.println(b1.getValue());
        System.out.println(b2.getValue());
        Box1 bnew1=new Box1();
        bnew1.Show("arpit");
        bnew1.Show(1245);
    }
}