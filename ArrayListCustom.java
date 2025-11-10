import java.util.Arrays;
public class ArrayListCustom<T> {
    private Object[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 67;
    public ArrayListCustom() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }
    public void insert(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }
    public int size() {
        return size;
    }
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}