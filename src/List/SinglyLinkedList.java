package List;

public class SinglyLinkedList implements List {
    static private class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;
    public SinglyLinkedList() {
        //더미노드 생성
        //head에서 x번 이동 = 인덱스 x-1번 노드
        head = new Node(0, null);
        size = 0;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    //succ 노드 뒤에 새 노드 삽입
    private void linkAfter(Node succ, int value) {
        Node newNode = new Node(value, succ.next);
        succ.next = newNode;
        size++;
    }

    //succ 노드의 다음 노드 삭제
    private int unlinkAfter(Node succ) {
        int x = succ.next.value;
        succ.next = succ.next.next;
        size--;
        return x;
    }

    //index 위치 노드 반환
    private Node Node(int index) {
        Node cur = head;
        for(int i=0; i<index + 1; i++) cur = cur.next;
        return cur;
    }

    @Override
    public boolean add(int value) {
        linkAfter(Node(size-1), value);
        return true;
    }

    @Override
    public void add(int index, int value) {
        if(index == size) {
            linkAfter(Node(size-1), value);
            return;
        }

        rangeCheck(index);
        linkAfter(Node(index-1), value);
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        return unlinkAfter(Node(index-1));
    }

    @Override
    public boolean remove(Integer value) {
        int index = indexOf(value);
        if(index == -1) return false;

        unlinkAfter(Node(index-1));
        return true;
    }

    @Override
    public int get(int index) {
        rangeCheck(index);
        return Node(index).value;
    }

    @Override
    public void set(int index, int value) {
        rangeCheck(index);
        Node(index).value = value;
    }

    @Override
    public boolean contains(int value) {
        if(indexOf(value) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(int value) {
        Node cur = head;
        for(int i=0; i<size; i++) {
            cur = cur.next;
            if(cur.value == value) return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }
    public void print(){
        System.out.println("--------");
        Node node = head;
        for(int i=0; i<size; i++){
            node = node.next;
            System.out.println(node.value + " ");
        }

        System.out.println("--------");
        System.out.println();
    }
}
