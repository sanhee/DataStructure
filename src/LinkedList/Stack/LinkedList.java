package LinkedList.Stack;

public class LinkedList implements MyStack {

    private Node head;
    private Node top;
    private int stackSize;

    public LinkedList(int stackSize) {
        this.head = null;
        this.top = null;
        this.stackSize = stackSize;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public boolean isFull() {
        if(isEmpty()){
            return false;
        }
        else{
            int nodeCount = 0;
            Node tempNode = head;

            while(tempNode.link != null){
                ++nodeCount;
                tempNode = tempNode.link;   // 다음 노드 참조
            }

            return (this.stackSize-1 == nodeCount);
        }
    }

    @Override
    public void push(String data) {
        Node newNode = new Node(data);

        if(isFull()){
            System.err.println("스택이 가득찼습니다.");
            return;
        }
        else if(isEmpty()){
            this.head = newNode;
            this.top = this.head;
        } else{ // 스택이 비어있지 않다면

            Node tempNode = top;

            while(tempNode.link != null){
                tempNode = tempNode.link;
            }

            tempNode.link = newNode;
        }

    }

    @Override
    public void pop() throws Exception {
        Node preNode;
        Node tempNode;

        if(isEmpty()){
            throw new Exception("스택이 비어있습니다.");
        }

        if(top.link == null){
            head = null;
            top = null;
        }else{
            preNode = top;
            tempNode = top.link;

            while(tempNode.link != null){
                preNode = tempNode;
                tempNode = tempNode.link;
            }

            preNode.link = null;
        }
    }

    public void printListStack() throws Exception {
        if (isEmpty()) {
            throw new Exception("스택이 비어있습니다.");
        } else {
            Node tempNode = this.top;

            while (tempNode != null) {
                System.out.print(tempNode.getData() + " ");
                tempNode = tempNode.link;
            }
            System.out.println();
        }
    }

}
