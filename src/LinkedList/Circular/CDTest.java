package LinkedList.Circular;

public class CDTest {

    public static void main(String[] args) {
        CDLinkedList<String> c = new CDLinkedList<String>();
        c.printAll();
        c.insertAfter(null, "월");
        c.printAll();
        c.insertAfter("월", "수");
        c.printAll();
        c.insertPrevious("수","화");
        c.printAll();
        c.insertLast("목");
        c.printAll();
        c.insertFront("일");
        c.printAll();
        c.removeAfter("일");
        c.printAll();
        c.removePrevious("목");
        c.printAll();
        c.removePrevious("일");
        c.printAll();
        c.removePrevious("일");
        c.printAll();
        c.removePrevious("일");
        c.printAll();
    }
}
