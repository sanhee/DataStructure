package LinkedList.Circular;

public class CDLinkedList<T> implements ICircularDoubleLinkedList<T>
{

    public CDNode<T> last; // 마지막 노드를 가리킴
    public int size; // 노드 개수를 저장

    public CDLinkedList() {
         last  = null;
         size = 0;
     }

    @Override
    public boolean search(T data) {

        // 연결리스트의 노드를 처음부터 탐색하고, 있다면 true, 없으면 false
        CDNode<T> p = last;
        for(int i = 0; i<size;i++){ // 리스트의 노드 수 만큼 반복
            if(data == p.data) return true;
            p = p.rightLink;
        }
        return false; // 데이터가 없음
    }

    public CDNode<T> findNode(T data){
        CDNode<T> p = last;
        for(int i=0;i<size;i++){
            if(data == p.data) return p; //m 값을 찾으면 해당 노드 반환
            p = p.rightLink;

        }
        return null;
    }

    // target 뒤에 데이터를 넣는 메소드
    @Override
    public void insertAfter(T target, T data) {
      CDNode<T> newNode = new CDNode<T>(null, data, null);
          if (last == null){ //m 리스트에 아무것도 없을 경우
              newNode.rightLink = newNode;
              newNode.leftLink = newNode;
              last = newNode;
          }
          else{ // 리스트에 데이터가 존재할 경우
              if(search(target)) // target이 리스트에 있음을 의미함
              {
                  CDNode<T> t = findNode(target); // target의 노드를 찾아와서 t로 선언
                  CDNode<T> p = t.rightLink; // target이 가리키는 오른쪽 노드를 p로 선언
                  t = p.leftLink; // 양방향으로 가리키고 있기 때문에

                  newNode.leftLink = t;
                  newNode.rightLink = p;
                  t.rightLink = newNode;
                  p.leftLink = newNode;
              }
          }
          size++; //노드 개수 +1
    }

    // 타겟 노드 앞에 데이터를 삽입하는 함수
    @Override
    public void insertPrevious(T target, T data) {

        CDNode<T> newNode = new CDNode<T>(null, data, null);
        if (last == null){ //m 리스트에 아무것도 없을 경우
            newNode.rightLink = newNode;
            newNode.leftLink = newNode;
            last = newNode;
        }
        else { // 리스트에 데이터가 존재할 경우
            if(search(target)) // target이 리스트에 있음을 의미함
            {
                CDNode<T> t = findNode(target);
                CDNode<T> p = t.leftLink;
                t = p.rightLink;

                newNode.leftLink = p;
                newNode.rightLink = t;
                p.rightLink = newNode;
                t.leftLink = newNode;

                if(t==last){ // target이 last 노드 일 수 있으므로
                    last = newNode;
                }

            }
        }
        size++;
    }

    // 맨 처음에 삽입
    @Override
    public void insertFront(T data) {

        CDNode<T> newNode = new CDNode<T>(null, data, null);
        if (last == null){ //m 리스트에 아무것도 없을 경우
            newNode.rightLink = newNode;
            newNode.leftLink = newNode;
            last = newNode;
        }
        else { // 리스트에 데이터가 존재할 경우, last가 가리키는 노드의 left(당시, 첫번쨰 노드) 이용

            CDNode<T> p = last.leftLink;
            p.rightLink = last;

            newNode.leftLink = p;
            newNode.rightLink = last;
            p.rightLink = newNode;
            last.leftLink = newNode;

            last = newNode;

          }

        size++;

    }

    // 리스트의 마지막에 삽입
    @Override
    public void insertLast(T data) {
        CDNode<T> newNode = new CDNode<T>(null, data, null);
        if (last == null){ //m 리스트에 아무것도 없을 경우
            newNode.rightLink = newNode;
            newNode.leftLink = newNode;
            last = newNode;
        }
        else { // 리스트에 데이터가 존재할 경우, last가 가리키는 노드의 left(당시, 첫번쨰 노드) 이용

            CDNode<T> p = last.leftLink;
            p.rightLink = last;

            newNode.leftLink = p;
            newNode.rightLink = last;
            p.rightLink = newNode;
            last.leftLink = newNode;

        }

        size++;
    }

    //
    @Override
    public void removeAfter(T target) {

        CDNode<T> t = findNode(target);

        if (last == null){
            System.out.println("데이터가 없습니다.");
        }
        else if(size ==1){
            last = null;
            size--;
        }
        else {
            CDNode<T> p = t.rightLink.rightLink;
            t = p.leftLink.leftLink;

            t.rightLink = p;
            p.leftLink = t;
            size--;

        }

    }

    @Override
    public void removePrevious(T target) {

        CDNode<T> t = findNode(target);

        if (last == null){
            System.out.println("데이터가 없습니다.");
        }
        else if(size ==1){
            last = null;
            size--;
        }
        else {
            CDNode<T> p = t.leftLink.leftLink;
            t = p.rightLink.rightLink;

            p.rightLink = t;
            t.leftLink = p;
            size--;
        }
    }

    @Override
    public void printAll() {

        if(last == null){

            System.out.println("데이터가 없습니다.");
        }
        else{
            System.out.print("List = {");
            for(int i = 0; i<size; i++){
                System.out.print(last.data+", ");
                last = last.rightLink;
            }
            System.out.println("}");

        }

    }
}