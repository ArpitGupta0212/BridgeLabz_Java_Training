public class LL{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }
    public void PrintList(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node curr=head;
        while (curr!=null) {
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("Linked List is Empty");
            return ;
        }
        Node curr=head.next;
        head=curr;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("Linked List is Empty");
            return ;
        }
        if(head.next==null){
            head=null;
        }
        Node secoundLast=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secoundLast=secoundLast.next;
        }
        secoundLast.next=null;
    }
    public static void main(String args[]){
        LL list=new LL();
        System.out.println();
        list.addLast(5);
        list.addLast(3);
        list.addLast(8);
        list.addLast(0);
        list.addLast(4);
        list.addLast(22);
        list.addFirst(20);
        System.out.println();
        list.PrintList();
        list.deleteLast();
        System.out.println();
        // list.deleteFirst();
        // System.out.println();
        list.PrintList();
    }
}