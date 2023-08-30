package List;

public class DoublyLinkedList implements List {
    static private class Node {
        int value;
        Node prev;
        Node next;
        Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private void linkFirst(int value) {
        Node h = head;
        Node newNode = new Node(null, value, h);
        head = newNode;
        if(h == null)
            tail = newNode;
        else
            h.prev = newNode;
        size++;
    }

    private void linkLast(int value) {
        Node t = tail;
        Node newNode = new Node(t, value, null);
        tail = newNode;
        if(t == null)
            head = newNode;
        else
            t.next = newNode;
        size++;
    }

    private int unlinkFirst() {
        Node h = head;
        int value = h.value;
        Node next = h.next;
        h = null;
        head = next;

        if(next == null)
            tail = null;
        else
            next.prev = null;
        size--;
        return value;
    }

    private int unlinkLast() {
        Node t = tail;
        int value = t.value;
        Node prev = t.prev;
        t = null;
        tail = prev;

        if(prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        return value;
    }

    private Node node(int index) {
        if(index < (size >> 1)) {
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        }
        else {
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private int unlink(Node x) {
        if(x == head) {
            return unlinkFirst();
        }
        else if(x == tail) {
            return unlinkLast();
        }

        int value = x.value;
        x.prev.next = x.next;
        x.next.prev = x.prev;
        x.prev = null;
        x.next = null;
        size--;
        return value;
    }

    private void linkBefore(int value, Node succ) {
        if(succ == head) {
            linkFirst(value);
            return;
        }

        Node newNode = new Node(succ.prev, value, succ);
        succ.prev.next = newNode;
        succ.prev = newNode;
        size++;
    }

    @Override
    public boolean add(int value) {
        linkLast(value);
        return true;
    }

    @Override
    public void add(int index, int value) {
        if(index == size) {
            add(value);
            return;
        }

        rangeCheck(index);
        linkBefore(value, node(index));
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        return unlink(node(index));
    }

    @Override
    public boolean remove(Integer value) {
        Node cur = head;
        for(int i=0; i<size; i++) {
            if(cur.value == value) {
                unlink(cur);
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int get(int index) {
        rangeCheck(index);
        return node(index).value;
    }

    @Override
    public void set(int index, int value) {
        rangeCheck(index);
        node(index).value = value;
    }

    @Override
    public boolean contains(int value) {
        Node cur = head;
        for(int i=0; i<size; i++) {
            if(cur.value == value)
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        Node cur = head;
        for(int i=0; i<size; i++) {
            if(cur.value == value)
                return i;
            cur = cur.next;
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
            System.out.println(node.value + " ");
            node = node.next;
        }

        System.out.println("--------");
        System.out.println();
    }
}