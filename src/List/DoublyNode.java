package List;

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