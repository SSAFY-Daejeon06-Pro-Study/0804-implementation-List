package 자료구조.List;


public class DoublyLinkedList implements List {
	private class Node {
		
		int num;
		Node prev;
		Node next;
		
		public Node(int num, Node prev, Node next) {
			
			this.num = num;
			this.prev = prev;
			this.next = next;
			
		}
	}
	
	static int size;
	static Node head;
	static Node tail;
	
    @Override
    public boolean add(int value) {
    	if(head == null) {
    		head = new Node(value, null, null);
    		tail = head;
    		size++;
    		return true;
    	}
    	
    	Node temp = new Node(value, tail, null);
    	tail.next = temp;
    	tail = temp;
    	size++;
    	
        return true;
    }

    @Override
    public void add(int index, int value) {
    	
    	// head 교체
    	if(index == 0 ) {
    		Node newHead = new Node(value, null, head);
    		head.prev = newHead;
    		head = newHead;
    		
    	}
    	else if(index == size) {
    		Node newTail = new Node(value, tail, null);
    		tail.next = newTail;
    		tail = newTail;
    	} else {
    		Node temp = head;
    		for(int i=0; i<index-1; i++) {
    			temp = temp.next;
    		}
    		
    		Node newNode = new Node(value, temp, temp.next);
    		temp.next = newNode;
    		newNode.next.prev = newNode;
    		
    	}
    	
    	size++;
    	
    }

    @Override
    public int remove(int index) {
    	
    	int returnVal = 0;
    	
    	// head 교체
    	if(index == 0 ) {
    		returnVal = head.num;
    		Node newHead = head.next;
    		newHead.prev = null;
    		head = newHead;
    		
    	}
    	else if(index == size-1) {
    		returnVal = tail.num;
    		Node newTail = tail.prev;
    		newTail.next = null;
    		tail = newTail;
    		
    	} else {
    		Node temp = head;
    		for(int i=0; i<index; i++) {
    			temp = temp.next;
    		}
    		returnVal = temp.num;
    		
    		temp.next.prev = temp.prev;
    		temp.prev.next = temp.next;
    		
    	}
    	size--;
        return returnVal;
    }

    @Override
    public boolean remove(Integer value) {
    	Node temp = head;
    	for(int i=0; i<size; i++) {
    		if(temp.num == value) {
    			remove(i);
    			return true;
    		}
    		temp = temp.next;
    	}
    	
        return false;
    }

    @Override
    public int get(int index) {
    	Node temp = head;
    	for(int i=0; i<index; i++) {
    		temp = temp.next;
    	}
    	
        return temp.num;
    }

    @Override
    public void set(int index, int value) {
    	Node temp = head;
    	for(int i=0; i<index; i++) {
    		temp = temp.next;
    	}
    	
        temp.num = value;
    }

    @Override
    public boolean contains(int value) {
    	
    	for(Node temp = head; temp!=null; temp = temp.next) {
    		if(temp.num == value) return true;
    	}
        return false;
    }

    @Override
    public int indexOf(int value) {
    	Node temp = head;
    	for(int i=0; i<size; i++) {
    		if(temp.num == value) return i;
    		temp = temp.next;
    	}
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
    	if(size == 0) return true;
        return false;
    }

    @Override
    public void clear() {
    	head = null;
    	tail = null;
    	size = 0;

    }
    
    public void print(){
        System.out.println("--------");
        Node node = head;
        for(int i=0; i<size; i++){
            System.out.println(node.num + " ");
            node = node.next;
        }

        System.out.println("--------");
        System.out.println();
    }
}
