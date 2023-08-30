package 리스트구현;

import java.util.Arrays;

public class ArrayList implements List {
	private static final int DEFAULT_CAPACITY = 10;
    private Integer[] array;
    private int size;
	
    public ArrayList() {
        this.array = new Integer[DEFAULT_CAPACITY];
        this.size = 0;
    }
    
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            return;
        }
        this.array = new Integer[initialCapacity];
        this.size = 0;
    }
    
    @Override
    public boolean add(int value) {
    	ensureCapacity(size + 1);
        array[size++] = value;
        return true;
    }

    private void ensureCapacity(int currentSize) {
    	if (currentSize > array.length) {
            int newCapacity = Math.max(array.length * 2, currentSize);
            array = Arrays.copyOf(array, newCapacity);
        }
	}

	@Override
    public void add(int index, int value) {

    }

    @Override
    public int remove(int index) {
    	if (index < 0 || index >= size) {
            return -1;
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return 1;
    }

    @Override
    public boolean remove(Integer value) {
    	int index = indexOf(value);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int get(int index) {
    	if (index < 0 || index >= size) {
           return -1;
        }
        return array[index];
    }

    @Override
    public void set(int index, int value) {
    	if (index < 0 || index >= size) {
            return;
        }
        array[index] = value;
    }

    @Override
    public boolean contains(int value) {
    	for(int i = 0; i<size; i++) {
    		if(value == array[i]) return true;
    	}
        return false;
    }

    @Override
    public int indexOf(int value) {
    	for(int i = 0; i<size; i++) {
    		if(value == array[i]) return i;
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
    	Arrays.fill(array, null);
        size = 0;
    }
}