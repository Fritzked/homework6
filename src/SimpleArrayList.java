/**
 * Simple array-based list.
 *
 * @param <E> type of elements stored
 */
public class SimpleArrayList<E> implements SimpleList<E> {
    private static final int initialCapacity = 10;
    private int accessCount;
    private E[] data;
    private int size;
    private int capacity;

    /**
     * Creates an empty array list.
     */
    public SimpleArrayList() {
        capacity = initialCapacity;
        data = (E[]) new Object[capacity];
        size = 0;
        accessCount = 0;
    }

    /**
     * Returns the access count.
     *
     * @return number of accesses
     */
    public int getAccessCount() {
        return accessCount;
    }

    /**
     * Resets the access count.
     */
    public void resetAccessCount() {
        accessCount = 0;
    }

    /**
     * Doubles the capacity of the array.
     */
    private void reallocate() {
        accessCount++;
        int newCapacity = capacity * 2;
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            accessCount++;
            newData[i] = data[i];
            accessCount++;
        }

        data = newData;
        capacity = newCapacity;
    }

    /**
     * Checks whether an index is valid.
     *
     * @param index index to check
     * @throws IndexOutOfBoundsException if index is invalid
     */
    private void validateIndex(int index) {
        accessCount++;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    /**
     * Returns the number of elements.
     *
     * @return list size
     */
    @Override
    public int size() {
        accessCount++;
        return size;
    }

    /**
     * Adds an element to the end.
     *
     * @param e element to add
     */
    @Override
    public void add(E e) {
        accessCount += 2;
        if (size == capacity) {
            reallocate();
        }

        accessCount += 2;
        data[size] = e;

        accessCount += 2;
        size++;
    }

    /**
     * Returns the element at an index.
     *
     * @param index index of element
     * @return element at index
     */
    @Override
    public E get(int index) {
        validateIndex(index);
        accessCount++;
        return data[index];
    }

    /**
     * Replaces the element at an index.
     *
     * @param index index to replace
     * @param e new element
     * @return previous element
     */
    @Override
    public E set(int index, E e) {
        validateIndex(index);

        accessCount++;
        E old = data[index];

        accessCount++;
        data[index] = e;

        return old;
    }

    /**
     * Returns the list as a string.
     *
     * @return list contents
     */
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < size; i++) {
            result += data[i] + " ";
        }

        return result;
    }
}
