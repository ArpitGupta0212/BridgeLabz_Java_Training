public class Queue_Implementation_Using_Array{
    static class Queue{
        static int arr[];
        static int size;
        static int rear=0;
        Queue(int n){
            arr=new int[n];
            this.size=n;
        }
        public static boolean isEmpty(){
            if(rear==0){
                return true;
            }
            return false;
        }
        public static void add(int data){
            if(rear==size){
                System.out.println("Full Queue");
                return;
            }
            arr[rear]=data;
            rear++;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int temp=arr[0];
            for(int i=1;i<rear;i++){
                arr[i-1]=arr[i];
            }
            rear--;
            return temp;
        }
        public static int peek(){
            if(isEmpty()){
                return-1;

            }
            return arr[0];
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