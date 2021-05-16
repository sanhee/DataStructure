package LinkedList.Stack;

// https://freestrokes.tistory.com/84?category=1045118 예제 따라치기

// List를 구성하는 Node 클래스
public class Node<T> {
    private T data;  // 데이터 저장 변수
    public Node link;  // 다른 노드를 참조할 링크 노드

    public Node(){
        this.data = null;
        this.link = null;
    }

    public Node(T data){
        this.data = data;
        this.link = null;
    }

    public Node(T data, Node link){
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }
}
