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

    private void removeDups(){  //m 중복 데이터 삭제 함수
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

    private static Node KthToLast(Node first, int k){ //m K번째 노드를 찾는 알고리즘, 방법1
        Node n = first;
        int total = 1;

        while(n.next != null){ // 마지막 노드에 가지 않으므로, total=1
            total++;
            n= n.next;
        }
        n= first;
        for(int i=1; i<total-k+1;i++){ // k가 1이면 마지막 노드를 가져와야 하므로 +1
            n = n.next;
        }
        return n;
    }

    private static class CountReference {
        public int count = 0;
    }

    private static Node KthToLast2(Node n, int k, CountReference r){
        if(n==null){
            return null;
        }
        Node found = KthToLast2(n.next, k, r);
        r.count++;
        if(r.count == k) {
            return n;
        }
        return found; //같지 않을 경우, 이미 찾아서 반환 받은 값을 반환
    }

    private static Node KthToLast3(Node first, int k){ // 공간 할당 없이, 2개의 포인터를 이용한 방법
        Node p1 = first;
        Node p2 = first;

        for(int i = 0; i<k; i++){
            if( p1 == null ) { // 뒤에서 k번째 값이 없다는 뜻
                return null;
            }
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    public static void main(String[] args) {

        LinkedList Link = new LinkedList();

        Link.append(1);
        Link.append(2);
        Link.append(3);
        Link.append(4);
        Link.retrieve();

        int k=1;
        //CountReference r = new CountReference();
        //Node found = KthToLast2(Link.header, k, r);
        Node found2 = KthToLast3(Link.header, k);
        //System.out.println(found.data);
        System.out.println(found2.data);

    }
}
