public class Circular_Queue_Implementation_Using_Array {
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front=-1;
        Queue(int n){
            arr=new int[n];
            this.size=n;
        }
        public static boolean isFull(){
            return rear+1 % size==front;
        }
        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }
        public static int  remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int re=arr[front];
            if(rear==front){
                rear=front=-1;
            }else{
                front=(front+1)%size;
            }
            return re;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String args[]){
        Queue qu=new Queue(5);
        qu.add(7);
        qu.add(0);
        qu.add(9);
        qu.add(10);
        qu.add(12);
        System.out.println(qu.peek());
        qu.remove();
        qu.remove();
        System.out.println(qu.peek());
    }
}
