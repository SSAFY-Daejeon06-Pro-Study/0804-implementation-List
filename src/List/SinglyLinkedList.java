package day0830;

public class SinglyLinkedList implements List {

    private Node head, tail;
    private int size;

    private void checkBound(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node searchByIndex(int index){
        checkBound(index);

        Node tmp = head;
        for(int i=0; i<index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }

    private void addFirst(int value){
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

        if(head.next == null){
            tail = head;
        }

        size++;
    }

    @Override
    public boolean add(int value) {
        if(size == 0){
            addFirst(value);
            return true;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;

        size++;
        return true;
    }

    @Override
    public void add(int index, int value) {
        checkBound(index);

        if(index == 0){
            addFirst(value);
            return;
        }

        Node pre = searchByIndex(index-1);
        Node newNode = new Node(value);

        newNode.next = pre.next;
        pre.next = newNode;

        if(newNode.next == null){
            tail = newNode;
        }

        size++;
    }

    @Override
    public int remove(int index) {
        checkBound(index);

        Node pre = searchByIndex(index-1);
        Node removeNode = pre.next;
        int data = removeNode.data;

        pre.next = removeNode.next;
        removeNode = null; // 명시적 제거

        if(pre.next == null){
            tail = pre;
        }

        size--;
        return data;
    }

    @Override
    public boolean remove(Integer value) {
        Node tmp = head;
        for(int i=0; i<size; i++){
            if(value.equals(tmp.data)){
                remove(i);
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    @Override
    public int get(int index) {
        return searchByIndex(index).data;
    }

    @Override
    public void set(int index, int value) {
        Node tmp = searchByIndex(index);
        tmp.data = value;
    }

    @Override
    public boolean contains(int value) {
        Node tmp = head;
        for(int i=0; i<size; i++){
            if(value == tmp.data){
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    @Override
    public int indexOf(int value) {
        Node tmp = head;
        for(int i=0; i<size; i++){
            if(value == tmp.data){
                return i;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void print(){
        System.out.println("--------");
        Node node = head;
        for(int i=0; i<size; i++){
            System.out.println(node.data + " ");
            node = node.next;
        }

        System.out.println("--------");
        System.out.println();
    }

    private class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
