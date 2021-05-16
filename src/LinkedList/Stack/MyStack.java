package LinkedList.Stack;

/*
 * @ TITLE Linked List Stack (연결리스트로 구현한 스택)
 */
// 스택의 기능을 정의한 인터페이스
interface MyStack {
    boolean isEmpty();
    boolean isFull();
    void push(String data);
    void pop() throws Exception;
}



