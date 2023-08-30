package 자료구조.List;

import java.util.Arrays;

public class ArrayList implements List {
	
	static final int DEFALUT_CAPACITY = 5;
	int size;
	int[] myArrayList;
	
	public ArrayList() {
		
		myArrayList = new int[DEFALUT_CAPACITY];
		
	}
	
	public ArrayList(int initialSize) {
		
		myArrayList = new int[DEFALUT_CAPACITY];
		
	}
	

	
	private void resize() {
		
		int nowCapacity = myArrayList.length;
		
		if(nowCapacity == size) {
			
//			System.arraycopy(myArrayList, 0, temp, 0, nowCapacity);
			myArrayList = Arrays.copyOf(myArrayList, nowCapacity*2);
			
			
		}
		else if((nowCapacity/2) > size) {
			
			myArrayList = Arrays.copyOf(myArrayList, Math.max(DEFALUT_CAPACITY, nowCapacity/2));
			
		}
			
	}
	
    @Override
    public boolean add(int value) {
    	
    	resize();
    	
    	myArrayList[size++] = value;
    	
        return true;
    }

    @Override
    public void add(int index, int value) {
    	
    	
    	if(index > size) {
    		throw new IndexOutOfBoundsException();
    	}
    	else if(index == size) {
    		add(value);
    	} else {
    		
    		resize();
    		
    		for(int i=size; i>index; i--) {
    			myArrayList[i] = myArrayList[i-1];
    		}
    		
    		myArrayList[index] = value;
    		size++;
    		
    	}
    	
    }

    @Override
    public int remove(int index) {
    	int returnVal = 0;
    	if(index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	else if(size-1 == index) {
    		returnVal = myArrayList[index-1];
    		myArrayList[index] = 0;
    	} else {
    		returnVal = myArrayList[index];
    		for(int i = index; i<size; i++) {
    			myArrayList[i] = myArrayList[i+1];
    		}
    		
    		myArrayList[size-1] = 0;
    	}
    	
    	size--;
        return returnVal;
    }

    @Override
    public boolean remove(Integer value) {
    	for(int i=0; i<size; i++) {
    		if(myArrayList[i] == value) {
    			remove(i);
    			size--;
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public int get(int index) {
        return myArrayList[index];
    }

    @Override
    public void set(int index, int value) {
    	myArrayList[index] = value;
    }

    @Override
    public boolean contains(int value) {
    	for(int i=0; i<size; i++) {
    		if(myArrayList[i] == value) return true;
    	}
        return false;
    }

    @Override
    public int indexOf(int value) {
    	for(int i=0; i<size; i++) {
    		if(myArrayList[i] == value) return i;
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
    	myArrayList = null;
    	size = 0;
    }
    
    public void print(){
        System.out.println("--------");
        for(int i=0; i<size; i++){
            System.out.println(myArrayList[i]+ " ");
        }

        System.out.println("--------");
        System.out.println();
    }
}
