package LinkedList.Single;

public class Single{

    private int data = 0;
    private Single next = null;

    Single(int d){
        this.data = d;
    }

    void append(int d){
        Single node_end = new Single(d);
        Single node = this;

        while (node.next != null){
            node = node.next;
        }
        node.next = node_end;
    }

    void delete(int d){
        Single node = this;

        while(node.next != null){
            if(node.next.data == d){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }

        }
    }

    void retrieve(){
        Single node = this;

        while (node.next != null){

            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.println(node.data);

    }


    public static void main(String[] args) {
        Single head = new Single(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(1);
        head.retrieve();
    }
}
