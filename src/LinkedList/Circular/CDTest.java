package LinkedList.Circular;

public class CDTest {

    public static void main(String[] args) {
        CDLinkedList<String> c = new CDLinkedList<String>();
        c.printAll();
        c.insertAfter(null, "월");
        c.printAll();
        c.insertAfter("월", "수");
        c.printAll();
        c.insertAfter("수", "목");
        c.printAll();
        c.removeNode("목");
        c.printAll();
        c.removeNode("월");
        c.printAll();
    }
}
