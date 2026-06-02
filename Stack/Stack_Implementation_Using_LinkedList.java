public class Stack_Implementation_Using_LinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        static Node head;
        static int size=0;
        public static boolean isEmpty(){
            return head==null;
        }
        // Push
        public static void  push(int data){
            Node NewNode=new Node(data);
            if(isEmpty()){
                head=NewNode;
                size++;
                return;
            }
            NewNode.next=head;
            head=NewNode;
            size++;
        }
        public static int size(){
            return size;
        }
        // pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            Node temp=head;
            head=head.next;
            size--;
            return temp.data;
           
        }
        // Peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(3);
        st.push(8);
        st.push(6);
        st.push(9);
        st.push(0);
        System.out.println(st.peek());
        st.pop();
        st.pop();
        System.out.println(st.peek());
        System.out.println(st.size());
    }
}
