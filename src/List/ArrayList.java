package List;

import java.util.Arrays;

public class ArrayList implements List {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elementData;
    private int size;

    public ArrayList() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    private void reSize() {
        int capacity = elementData.length;

        //용량이 꽉 찬 경우, 용량을 50% 늘려줌
        if (size == capacity) {
            int newCapacity = capacity + (capacity >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        //크기가 용량의 25% 보다 작은경우, 용량을 50% 줄여줌
        else if ((capacity >> 2) > size) {
            int halfCapacity = capacity >> 1;
            elementData = Arrays.copyOf(elementData, Math.max(halfCapacity, DEFAULT_CAPACITY));
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(int value) {
        reSize();
        elementData[size++] = value;
        return true;
    }

    @Override
    public void add(int index, int value) {
        //맨 뒤에 삽입
        if(index == size) {
            add(value);
            return;
        }

        rangeCheck(index);
        reSize();
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }
    @Override
    public int remove(int index) {
        rangeCheck(index);

        int element = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = 0;
        size--;
        reSize();
        return element;
    }

    @Override
    public boolean remove(Object value) {
        for (int index = 0; index < size; index++) {
            if (value.equals(elementData[index])) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        rangeCheck(index);

        return elementData[index];
    }

    @Override
    public void set(int index, int value) {
        rangeCheck(index);

        elementData[index] = value;
    }

    @Override
    public boolean contains(int value) {
        for(int index=0; index < size; index++) {
            if(elementData[index] == value) return true;
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        for(int index=0; index < size; index++) {
            if(elementData[index] == value) return index;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }
}
