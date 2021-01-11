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

    void removeDups(){  //m 중복 데이터 삭제 함수
        Node n = header;
        while(n != null && n.next != null){ // 삭제후 n이 null일 수 있음
            Node r = n;
            while(r.next != null){ // 마지막 노드에는 가지않음.
                if(n.data == r.next.data){ // 가리키는 노드가, 삭제할 노드 전
                    r.next = r.next.next;
                }
                else{ // 중복이 없을 경우
                    r = r.next;
                }
            }
            n = n.next; // 다음 n으로 이동.
        }
    }

    public static void main(String[] args) {
        LinkedList Link = new LinkedList();

        Link.append(1);
        Link.append(2);
        Link.append(2);
        Link.append(3);
        Link.append(3);
        Link.append(4);
        Link.append(4);
        Link.append(5);
        Link.retrieve();

        Link.removeDups();
        Link.retrieve();


    }
}
