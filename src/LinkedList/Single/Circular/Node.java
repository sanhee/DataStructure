package LinkedList.Single.Circular;

public class Node {
    protected int data;
    protected Node next, prev;

    // 생성자
    public Node(){
        this.next = null;
        this.prev = null;
        this.data = 0;
    }
    public Node(int d, Node n, Node p){
        this.data = d;
        this.next = n;
        this.prev = p;
    }
    // 다음 노드 설정
    public void setLinkNext(Node n){
        this.next = n;
    }
    // 이전 노드 설정
    public void setLinkPrev(Node p){
        prev = p;
    }
    // 노드의 링크를 가져오는 함수
    public Node getLinkNext(){
        return next;
    }
    public Node getLinkPrev(){
        return prev;
    }
    public void setData(int d){
        data = d;
    }
    public int getData(){
        return data;
    }

}
