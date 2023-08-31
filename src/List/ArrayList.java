package List;

public class ArrayList implements List {
	
	private int MAX_SIZE = 10;
	private int size = 0;
	private int[] arr; 
	
	ArrayList(){
		arr = new int[MAX_SIZE];
	}
	
	private void checkBound(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void resizeIfFull() {
		if(size < MAX_SIZE) return;
		
		int nextSize = MAX_SIZE*2;
		
		resize(nextSize);
	}
	
	private void contractMaxSize() {
		if((size/10) + 2 > (MAX_SIZE/10)) return;
		
		int nextSize = ((size/10) + 2)*10;
		
		resize(nextSize);
	}
	
	private void resize(int nextSize) {
		int[] tmp = new int[nextSize];
		System.arraycopy(arr, 0, tmp, 0, size);
		
		MAX_SIZE = nextSize;
		arr = tmp;
	}
	
    @Override
    public boolean add(int value) {
    	resizeIfFull();

    	arr[size++] = value;
        return true;
    }

    @Override
    public void add(int index, int value) {
    	checkBound(index);
    	resizeIfFull();
    	
    	for(int i=size; i>index; i--) {
    		arr[i] = arr[i-1];
    	}
    	arr[index] = value;
    	size++;
    }

    @Override
    public int remove(int index) {
    	checkBound(index);
    	
    	for(int i=index; i< size-1; i++) {
    		arr[i] = arr[i+1];
    	}
    	
    	int value = arr[size-1];
    	arr[size-1] = 0;
    	size--;
    	
    	contractMaxSize();
        return value;
    }

    @Override
    public boolean remove(Integer value) {
    	for(int i=0; i<size; i++) {
    		if(value.equals(arr[i])) {
    			remove(i);
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public int get(int index) {
    	checkBound(index);
    	
        return arr[index];
    }

    @Override
    public void set(int index, int value) {
    	checkBound(index);
    	
    	arr[index] = value;
    }

    @Override
    public boolean contains(int value) {
    	for(int i=0; i<size; i++) {
    		if(value == arr[i]) {
    			return true;
    		}
    	}
    	
        return false;
    }

    @Override
    public int indexOf(int value) {
    	for(int i=0; i<size; i++) {
    		if(value == arr[i]) {
    			return i;
    		}
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
    	arr = new int[10];
    	size = 0;
    }

    @Override
    public void print(){
        System.out.println("--------");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n원소 개수 : " + size + " 배열 사이즈 : " + arr.length);
        System.out.println("\n--------");
        System.out.println();
    }
}
