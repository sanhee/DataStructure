package LinkedList.Circular;

public interface ICircularDoubleLinkedList<T> {

    public boolean search(T data);
    public void insertAfter(T target, T data);
    public void insertPrevious(T target, T data);
    public void insertFront(T data);
    public void insertLast(T data);
    public void removeNode(T target);
    public void removeAfter(T target);
    public void removePrevious(T target);
    public void printAll();
}
