package 자료구조.List;

class Node {
	static int size;
	static Node head;
	static Node tail;
	
	int num;
	Node next;
	
	public Node(int num, Node next) {
		
		this.num = num;
		this.next = next;
		
	}
}

public class SinglyLinkedList implements List {
	
	
	
    @Override
    public boolean add(int value) {
    	if(Node.head == null) {
    		Node.head = new Node(value, null);
    		Node.tail = Node.head;
    		Node.size++;
    		return true;
    	}
    	
    	Node tail = Node.tail;
    	tail.next = new Node(value, null);
    	Node.tail = tail.next;
    	Node.size++;
    	
        return true;
    }

    @Override
    public void add(int index, int value) {
    	if(index == 0) {
    		Node newHead = new Node(value, Node.head);
    		Node.head = newHead;
    	}
    	else if(index == Node.size) {
    		Node newTail = new Node(value, null);
    		Node.tail.next = newTail;
    		Node.tail = newTail;
    		
    	}
    	else {
    		Node temp = Node.head;
    		for(int i=0; i<index-1; i++) {
    			temp = temp.next;
    		}
    		temp.next = new Node(value, temp.next);
    		
    	}
    	
    	Node.size++;
    	
    	return;
    }

    @Override
    public int remove(int index) {
    	int returnValue = 0;
    	
    	// head 삭제일때
    	if(index == 0) {
    		returnValue = Node.head.num;
    		Node.head = Node.head.next;
    	}
    	
    	else {
    		Node temp = Node.head;
    		for(int i=0; i<index-1; i++) {
    			temp = temp.next;
    		}
    		
    		// tail을 삭제해야 할 때
    		if(index == Node.size-1) {
    			returnValue = Node.tail.num;
    			Node.tail = temp;
    			temp.next = null;
    		} else {
    			returnValue = temp.next.num;
    			temp.next = temp.next.next;
    		}
    		
    	}
    	
    	Node.size--;
    	
    	
        return returnValue;
    }

    @Override
    public boolean remove(Integer value) {

    	if(Node.head.num == value) {
    		Node.head = Node.head.next;
    		Node.size--;
    		return true;
    	}
    	
    	Node prevNode = null;
    	
    	for(Node temp = Node.head; temp != null; temp = temp.next) {
    		
    		if(temp.num != value) {
    			prevNode = temp;
    			temp = temp.next;
    		} else {
    			// 값을 찾았는데 tail일때
    			if(Node.tail.equals(temp)) {
    				Node.tail = prevNode;
    				Node.size--;
    				return true;
    				
    			}
    			prevNode.next = temp.next;
    			Node.size--;
    			return true;
    		}
    		
    	}
    	
        return false;
    }

    @Override
    public int get(int index) {
    	
    	Node temp = Node.head;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
        return temp.num;
    }

    @Override
    public void set(int index, int value) {
    	Node temp = Node.head;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		temp.num = value;
    }

    @Override
    public boolean contains(int value) {
    	for(Node temp = Node.head; temp != null; temp = temp.next) {
    		if(temp.num == value) return true;
    	}
        return false;
    }

    @Override
    public int indexOf(int value) {
    	Node temp = Node.head;
		for(int i=0; i<Node.size; i++) {
			if(temp.num == value) return i;
			temp = temp.next;
		}
        return -1;
    }

    @Override
    public int size() {
        return Node.size;
    }

    @Override
    public boolean isEmpty() {
    	if(Node.size == 0) return true;
        return false;
    }

    @Override
    public void clear() {
    	Node.head = null;
    	Node.tail = null;
    	Node.size = 0;
    	
    }
    
    public void print(){
        System.out.println("--------");
        Node node = Node.head;
        for(int i=0; i<Node.size; i++){
            System.out.println(node.num + " ");
            node = node.next;
        }

        System.out.println("--------");
        System.out.println();
    }
}
