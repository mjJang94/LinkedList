import javax.xml.soap.Node;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;


    private class Node{

        //데이터가 저장될 필드
        private Object data;

        //다음 노드를 가르키는 필드
        private Node next;

        public Node(Object input){
            this.data = input;
            this.next = null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input){
        Node newNode = new Node(input);

        newNode.next = head;

        head = newNode;

        size++;

        if (head.next == null){
            tail = head;
        }
    }

    public void addLast(Object input){
        Node newNode = new Node(input);

        if (size == 0){
            addFirst(input);
        }else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    Node node(int index){
        Node x = head;

        for (int i = 0; i < index; i++)
            x = x.next;

            return x;
    }

    public void add(int k, Object input){

        if (k == 0){
            addFirst(input);
        }else {
            Node temp1 = node(k -1);
            Node temp2 = temp1.next;

            Node newNode = new Node(input);

            temp1.next = newNode;

            newNode.next = temp2;

            size++;

            if (newNode.next == null){
                tail = newNode;
            }
        }
    }
}

//https://opentutorials.org/module/1335/8857
