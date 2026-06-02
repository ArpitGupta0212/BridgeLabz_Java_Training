public class Queue_Implementation_Using_LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        static Node head;
        static Node tail;
        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        public static void add(int data){
            Node newNode=new Node (data);
            if(isEmpty()){
                head=newNode;
                tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            if(head==tail){
                tail=null;
            }
            int temp=head.data;
            head=head.next;
            return temp;
        }
        public static int peek(){
            return head.data;
        }
    }
    public static void main(String args[]){
        Queue qu=new Queue();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        while(!qu.isEmpty()){
            System.out.println(qu.peek());
            qu.remove();
        }
    } 
}
