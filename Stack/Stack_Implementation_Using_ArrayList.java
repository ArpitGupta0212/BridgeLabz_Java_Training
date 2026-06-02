import java.util.*;
public class Stack_Implementation_Using_ArrayList {
    static class Stack{
        public static ArrayList<Integer> list=new ArrayList<>();
        public static boolean isEmpty(){
            if(list.size()==0){
                return true;
            }
            return false;
        }
        public static void push(int data){
            if(isEmpty()){
                list.add(data);
                return;
            }
            list.addFirst(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int temp=list.get(0);
            list.remove(0);
            return temp;
        }
        public static int size(){
            return list.size();
        }
        public static int peek(){
            return list.get(0);
        }
    }

    public static void main(String args[]){
        Stack st=new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.err.println(st.size());
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }    
}
