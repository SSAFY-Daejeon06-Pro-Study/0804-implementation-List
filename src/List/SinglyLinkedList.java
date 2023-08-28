package List;

import java.util.LinkedList;

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
        //head에서 size번 이동 = 인덱스 size-1번 노드
        head = new Node(0, null);
        size = 0;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(int value) {
        Node newNode = new Node(value, null);

        Node tail = head;
        for(int i=0; i<size; i++) tail = tail.next;

        newNode.next = tail.next;
        tail.next = newNode;
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
        Node newNode = new Node(value, null);

        Node pre = head;
        for(int i=0; i<index; i++) pre = pre.next;

        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);

        Node pre = head;
        for(int i=0; i<index; i++) pre = pre.next;

        Node delNode = pre.next;
        int delValue = delNode.value;
        pre.next = pre.next.next;
        delNode.next = null;
        size--;
        return delValue;
    }

    @Override
    public boolean remove(Integer value) {
        Node pre = head;
        for(int i=0; i<size-1; i++) {
            if(pre.next.value == value) {
                Node delNode = pre.next;
                pre.next = pre.next.next;
                delNode.next = null;
                size--;
                return true;
            }
            pre = pre.next;
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
        for(Node x = head; x != null;) {
            Node next = x.next;
            x.next = null;
            x = next;
        }
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
