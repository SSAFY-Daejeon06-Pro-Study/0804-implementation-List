package List;

public class DoublyLinkedList implements List {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int value) {
        DoublyNode node = new DoublyNode(value, tail, null);
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
        DoublyNode node;
        if (index == size) {
            add(value);
        } else if (index == 0) {
            node = new DoublyNode(value, null, head);
            head.prev = node;
            head = node;
            size++;
        } else {
            DoublyNode prev = search(index - 1);
            DoublyNode next = prev.next;
            node = new DoublyNode(value, prev, next);
            prev.next = node;
            next.prev = node;
            size++;
        }
    }

    @Override
    public int remove(int index) {
        DoublyNode deleteNode = search(index);
        removeNode(deleteNode);
        return deleteNode.data;
    }

    @Override
    public boolean remove(Integer value) {
        if (value == null) {
            return false;
        }
        for (DoublyNode node = head; node != null; node = node.next) {
            if (value.equals(node.data)) {
                removeNode(node);
                return true;
            }
        }
        return false;
    }

    private void removeNode(DoublyNode node) {
        DoublyNode prev = node.prev;
        DoublyNode next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }

        size--;
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
        DoublyNode node = head;
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

    private DoublyNode search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        DoublyNode node;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }
}

class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode(int data, DoublyNode prev, DoublyNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}