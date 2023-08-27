package List;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList implements List {
    private static final int DEFAULT_CAPACITY = 10; // 크기를 따로 설정하지 않으면 설정되는 디폴트 크기
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; // 배열의 최대 크기
    private static final int[] EMPTY_ARRAY = {};
    private int size; // 원소의 개수
    private int[] array; // 원소가 실제 저장되는 공간

    // 공간 할당하지 않고 객체만 만드는 경우
    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 생성 시 공간 할당하는 경우
    public ArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    @Override
    public boolean add(int value) {
        if (size == array.length) {
            if (size == MAX_ARRAY_SIZE) {
                return false;
            }
            resize();
        }
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == index) {
            add(value);
        } else {
            if (size == array.length) {
                resize();
            }
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
        }
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int removedValue = array[index];
        array[index] = 0;
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0;
        size--;
        resize();
        return removedValue;
    }

    @Override
    public boolean remove(Integer value) {
        int removeIndex = indexOf(value);
        if (value == null || removeIndex == -1) {
            return false;
        }
        remove(removeIndex);
        return true;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
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
        array = EMPTY_ARRAY;
        size = 0;
    }

    private void resize() {
        int array_capacity = array.length;

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new int[DEFAULT_CAPACITY];
            return;
        }

        if (size == array_capacity) {
            int new_capacity = array_capacity << 1;
            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        if (size < array_capacity >> 1) {
            int new_capacity = array_capacity >> 1;
            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
        }
    }
}
