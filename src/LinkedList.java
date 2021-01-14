import javax.xml.soap.Node;

public class LinkedList {

    // 첫번째 노드
    private Node head;
    // 마지막 노드
    private Node tail;
    // 엘리먼트 갯수
    private int size = 0;


    /**
     * 노드는 실제 데이터가 저장되는 공간이다.
     * 노드 객체는 리스트의 내부 부품이기 때문에 외부에는 노출되지 않는 것이 좋디.
     * 이 노드를 사용하는 사용자들은 이 객체에 대한 알 필요가 없다.
     */
    private class Node {

        //데이터가 저장될 필드
        private Object data;

        //다음 노드를 가르키는 필드
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        //노드에 담긴 데이터를 출력
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    /**
     * 첫번째 자리에 추가
     */
    public void addFirst(Object input) {
        //노드 생성
        Node newNode = new Node(input);
        //새로운 노드의 다음 노드로 head 지정
        newNode.next = head;
        //헤드로 새로운 노드 지정
        head = newNode;
        //엘리먼트 갯수 1 증가
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    /**
     * 끝에 추가
     */
    public void addLast(Object input) {
        // 노드 생성
        Node newNode = new Node(input);

        //리스트의 노드가 없으면 첫번째 노드를 추가
        if (size == 0) {
            addFirst(input);
        } else {
            //마지막 노드의 다음 노드로 생성한 노드를 지정
            tail.next = newNode;
            //마지막 노드 갱신
            tail = newNode;
            //엘리먼트 갯수 1 증가
            size++;
        }
    }

    /**
     * 특정 위치의 노드 탐색
     */
    Node node(int index) {
        Node x = head;

        for (int i = 0; i < index; i++)
            x = x.next;

        return x;
    }

    /**
     * 특정 위치에 노드를 추가
     */
    public void add(int k, Object input) {
        //k가 0이면 첫번째 노드에 추가하는 것이기 때문에 addFirst 를 통해 추가
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            //k 번째 노드를 temp2로 지정
            Node temp2 = temp1.next;
            //새로운 노드 생성
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드 저장
            temp1.next = newNode;
            //새로운 노드의 다음 노드로 tmp2 저장
            newNode.next = temp2;

            size++;
            // 새로운 노드의 다음 노드가 없으면 새로운 노드가 마지막이므로 tail 에 저장
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    /**
     * 출력
     */
    public String toString() {
        //노드가 없다면 []를 리턴합니다
        if (head == null) {
            return "[]";
        }

        //탐색을 시작합니다.
        Node temp = head;
        String str = "[";

        //다음 노드가 없을 때까지 반복 실행
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }
        //마지막 노드를 출력결과에 포함
        str += temp.data;
        return str + "]";
    }

    /**
     * 첫번째 노드 삭제
     */
    public void removeFirst(){
        //첫 번째 노드를 temp로 지정하고 head의 값을 두 번재 노드로 변경
        Node temp = head;
        head = temp.next;
        size--;
    }

    /**
     * 중간 노드 삭제
     */
    public void remove(int k){
        if (k == 0){
            removeFirst();
        }

        Node temp = node(k-1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;

        if (todoDeleted == tail){
            tail = temp;
        }

        size--;
    }

    /**
     * 엘리먼트 크기
     */
    public int size(){
        return size;
    }

    /**
     * 엘리먼트 가져오기
     */
    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
}


