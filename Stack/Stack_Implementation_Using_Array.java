public class Stack_Implementation_Using_Array {
    static class Stack{
        static int size;
        static int arr[]=new int[5];
        public static boolean isEmpty(){
            if(size==0){
                return true;
            }
            return false;
        }
        public static void push(int data){
            arr[size]=data;
            size++;
        }
        public static int pop(){
            int temp=arr[size-1];
            size--;
            return temp;
        }
        public static int peek(){
            int temp=arr[size-1];
            return temp;
        }
        public static int size(){
            return size;
        }
        public static boolean isFull(){
            return size==arr.length;
        }
    }
    public static void main(String args[]){
        Stack st=new Stack();
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
        st.push(3);
        st.push(8);
        st.push(6);
        st.push(9);
        st.push(0);
        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
        st.pop();
        st.pop();
        System.out.println(st.peek());
        System.out.println(st.size());
    }
}
