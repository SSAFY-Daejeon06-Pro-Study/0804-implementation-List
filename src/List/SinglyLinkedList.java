package List;

public class SinglyLinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(int value) {
        Node node = new Node(value, null);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    @Override
    public void add(int index, int value) {
        if (index == size) {
            add(value);
        } else if (index == 0) {
            head = new Node(value, head);
            size++;
        } else {
            Node prev = search(index - 1);
            prev.next = new Node(value, prev.next);
            size++;
        }
    }

    @Override
    public int remove(int index) {
        Node deleteNode = search(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = search(index - 1);
            prev.next = deleteNode.next;
            if (deleteNode == tail) {
                tail = prev;
            }
        }
        size--;
        return deleteNode.data;
    }

    @Override
    public boolean remove(Integer value) {
        if (value == null) {
            return false;
        }
        Node prev = null;
        for (Node now = head; now != null; now = now.next) {
            if (value.equals(now.data)) {
                if (prev == null) {
                    head = now.next;
                } else {
                    prev.next = now.next;
                }
                if (now == tail) {
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = now;
        }
        return false;
    }

    @Override
    public int get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, int value) {
        search(index).data = value;
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(int value) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.data == value) {
                return i;
            }
            node = node.next;
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

    private Node search(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}