package 리스트구현;



public class DoublyLinkedList implements List {
	class Node {
	    int value;
	    Node prev;
	    Node next;

	    public Node(int value) {
	        this.value = value;
	        this.prev = null;
	        this.next = null;
	    }
	}
	private Node head;
    private Node tail;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    @Override
    public boolean add(int value) {
    	 Node newNode = new Node(value);
         if (head == null) {
             head = newNode;
             tail = newNode;
         } else {
             tail.next = newNode;
             newNode.prev = tail;
             tail = newNode;
         }
         return true;
    }

    @Override
    public void add(int index, int value) {
    	 Node newNode = new Node(value);
         if (index == 0) {
             if(head == null) add(value);
             else {
            	 newNode.next = head;
                 head.prev = newNode;
                 head = newNode;
             }
         } else {
             Node current = head;
             int currentIdx = 0;
             while (current != null && currentIdx < index - 1) {
                 current = current.next;
                 currentIdx++;
             }

             if (current == null) {
                 return;
             }

             newNode.next = current.next;
             newNode.prev = current;
             current.next = newNode;
         }
    }

    @Override
    public int remove(int index) {
    	if (index < 0) {
            return -1;
        }
    	//헤드 삭제
        if (index == 0) {
            if (head != null) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
                return 1;
            }
            return -1;
        }

        Node current = head;
        int currentIdx = 0;
        while (current != null && currentIdx < index) {
            current = current.next;
            currentIdx++;
        }

        if (current == null) {
        	return -1;
        }

        if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return 1;
    }

    @Override
    public boolean remove(Integer value) {
    	Node current = head;
        while (current != null) {
            if (current.value == value) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int get(int index) {
    	if (index < 0) {
    		return -1;
        }

        Node current = head;
        int currentIdx = 0;
        while (current != null && currentIdx < index) {
            current = current.next;
            currentIdx++;
        }

        if (current == null) {
        	return -1;
        }

        return current.value;
    }

    @Override
    public void set(int index, int value) {
    	if (index < 0) {
    		return;
        }

        Node current = head;
        int currentIdx = 0;
        while (current != null && currentIdx < index) {
            current = current.next;
            currentIdx++;
        }

        if (current == null) {
        	return;
        }

        current.value = value;
    }

    @Override
    public boolean contains(int value) {
        Node current = head;
        while (current != null && current.value != value) {
            current = current.next;
        }

        if (current == null) return false;
        return true;
    }

    @Override
    public int indexOf(int value) {
    	 Node current = head;
    	 int currentIdx = 0;
         while (current != null && current.value != value) {
             current = current.next;
             currentIdx++;
         }

         if (current == null) return -1;
         return currentIdx;
    }

    @Override
    public int size() {
    	 Node current = head;
    	 int currentIdx = 0;
         while (current != null) {
             current = current.next;
             currentIdx++;
         }

         if (current == null) return -1;
         return currentIdx;
    }

    @Override
    public boolean isEmpty() {
    	if(this.head == null) return true;
        return false;
    }

    @Override
    public void clear() {
    	this.head = null;
        this.tail = null;
    }
}