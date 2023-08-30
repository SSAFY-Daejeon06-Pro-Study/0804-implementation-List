package 리스트구현;



public class SinglyLinkedList implements List {
	class Node {
	    int value;
	    Node next;

	    public Node(int value) {
	        this.value = value;
	        this.next = null;
	    }
	}
	private Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
    @Override
    public boolean add(int value) {
    	 Node newNode = new Node(value);
         if (head == null) {
             head = newNode;
         } else {
             Node current = head;
             while (current.next != null) {
                 current = current.next;
             }
             current.next = newNode;
         }
         return true;
    }

    @Override
    public void add(int index, int value) {
    	Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            return; 
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    @Override
    public int remove(int index) {
    	if (index == 0) {
            head = head.next;
            return 1;
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null || current.next == null) {
            return 0; // 인덱스가 범위를 벗어나면 아무 작업도 하지 않음
        }

        current.next = current.next.next;
        return 1;
    }

    @Override
    public boolean remove(Integer value) {
    	 if (head == null) {
             return false; // 빈 리스트에서 삭제 시 아무 작업도 하지 않음
         }

         if (head.value == value) {
             head = head.next;
             return true;
         }

         Node current = head;
         while (current.next != null) {
             if (current.next.value == value) {
                 current.next = current.next.next;
                 return true;
             }
             current = current.next;
         }
        return false;
    }

    @Override
    public int get(int index) {
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
        if (current == null) {
            return false;
        }
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
        if (current == null) {
            return -1;
        }
        return currentIdx;
    }

    @Override
    public int size() {
    	Node current = head;
        int currentIdx = 0;
        if(head == null) return 0;
        while (current.next != null) currentIdx++; 
        return currentIdx+1;
    }

    @Override
    public boolean isEmpty() {
    	if(head == null) return true;
        return false;
    }

    @Override
    public void clear() {
    	head = null;
    }
}