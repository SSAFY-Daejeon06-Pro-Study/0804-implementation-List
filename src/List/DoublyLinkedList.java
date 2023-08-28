package List;

import java.util.LinkedList;

public class DoublyLinkedList implements List {
    static private class Node {
        int value;
        Node prev;
        Node next;
        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        //더미노드 생성
        //head에서 x번 이동 = 인덱스 x-1번 노드
        //head에서 size번 이동 = 인덱스 size-1번 노드
        head = new Node(0, null, null);
        tail = new Node(0, null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(int value) {
        Node newNode = new Node(value, null, null);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, int value) {
        if(index == size) {
            add(value);
            return;
        }

        rangeCheck(index);
        Node newNode = new Node(value, null, null);

        Node pre = head;
        for(int i=0; i<index; i++) pre = pre.next;

        newNode.prev = pre;
        newNode.next = pre.next;
        pre.next.prev = newNode;
        pre.next = newNode;
        size++;
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);

        Node cur = head;
        for(int i=0; i<index+1; i++) cur = cur.next;

        int delValue = cur.value;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.prev = null;
        cur.next = null;
        size--;
        return delValue;
    }

    @Override
    public boolean remove(Integer value) {
        Node cur = head;
        for(int i=0; i<size; i++) {
            cur = cur.next;
            if(cur.value == value) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.prev = null;
                cur.next = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        rangeCheck(index);

        Node cur = head;
        for(int i=0; i<index+1; i++) cur = cur.next;
        return cur.value;
    }

    @Override
    public void set(int index, int value) {
        rangeCheck(index);

        Node cur = head;
        for(int i=0; i<index+1; i++) cur = cur.next;
        cur.value = value;
    }

    @Override
    public boolean contains(int value) {
        Node cur = head;
        for(int i=0; i<size; i++) {
            cur = cur.next;
            if(cur.value == value) return true;
        }
        return false;
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
        for (Node x = head.next; x != tail; ) {
            Node next = x.next;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head.next = tail;
        tail.prev = head;
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