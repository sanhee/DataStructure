package LinkedList.Single.Circular;

public class linkedList {
    protected Node start;
    protected Node end;
    public int size;

    public linkedList(){
        start = null;
        end = null;
        size = 0;
    }
    // 리스트가 비어있는지 확인하는 함수
    public boolean isEmpty(){
        return start == null;
    }
    // 리스트의 사이즈를 얻는 함수
    public int getSize(){
        return size;
    }
    // 리스트 맨 앞에 데이터를 삽입하는 함수
    public void insertAtStart(int val){

        Node nptr = new Node(val, null, null);

        if(start == null){ // 리스트에 값이 없을 때
            nptr.setLinkNext(nptr);
            nptr.setLinkPrev(nptr);
            start = nptr;
            end = start;
        }
        else{
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }


    }


}
