package LinkedList.Single;

public class LinkedList {

    Node header;

    static class Node{
        int data;
        Node next = null;
    }

    LinkedList(){
        header = new Node();
    }

    void append(int d){
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;

    }

    void delete(int d){
        Node end = new Node();
        Node n = header;
        while (n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }
            else{
                n = n.next;
            }
        }
    }


    void retrieve(){
        Node n = header.next; //m 헤더는 출력하지 않기 위해서
        while ( n.next != null){

            System.out.print(n.data+" -> ");
            n = n.next;
        }
        System.out.println(n.data);

    }

    public static void main(String[] args) {
        LinkedList Link = new LinkedList();

        Link.append(1);
        Link.append(2);
        Link.append(3);
        Link.append(4);
        Link.append(5);

        Link.retrieve();
        Link.delete(1);
        Link.retrieve();


    }
}
