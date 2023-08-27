package List;

public class SinglyLinkedList implements List {
    private SinglyNode head;
    private SinglyNode tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(int value) {
        SinglyNode node = new SinglyNode(value, null);
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
            head = new SinglyNode(value, head);
            size++;
        } else {
            SinglyNode prev = search(index - 1);
            prev.next = new SinglyNode(value, prev.next);
            size++;
        }
    }

    @Override
    public int remove(int index) {
        SinglyNode deleteNode = search(index);
        if (index == 0) {
            head = head.next;
        } else {
            SinglyNode prev = search(index - 1);
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
        SinglyNode prev = null;
        for (SinglyNode now = head; now != null; now = now.next) {
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
        SinglyNode node = head;
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

    private SinglyNode search(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
        SinglyNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}