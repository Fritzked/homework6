/**
 * Simple linked list implementation.
 * @param <E> type of elements stored
 */
public class SimpleLinkedList<E> implements SimpleList<E> {
    private int accessCount;
    private int size;
    private Node<E> head;

    /**
     * Creates an empty linked list.
     */
    public SimpleLinkedList() {
        accessCount = 0;
        size = 0;
        head = null;
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
     * Checks if an index is valid.
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
     * Finds the node at the given index.
     *
     * @param index index of node
     * @return node at index
     */
    private Node<E> getNode(int index) {
        validateIndex(index);

        accessCount++;
        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            accessCount++;
            current = current.next;
        }

        return current;
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
     * Adds an element to the end of the list.
     *
     * @param e element to add
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

        accessCount++;
        if (head == null) {
            accessCount++;
            head = newNode;
        } else {
            accessCount++;
            Node<E> current = head;

            accessCount++;
            while (current.next != null) {
                accessCount++;
                current = current.next;
                accessCount++;
            }

            accessCount++;
            current.next = newNode;
        }

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
        Node<E> node = getNode(index);
        accessCount++;
        return node.data;
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
        Node<E> node = getNode(index);
        accessCount++;
        E old = node.data;
        accessCount++;
        node.data = e;
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
        Node<E> current = head;

        while (current != null) {
            result += current.data + " ";
            current = current.next;
        }

        return result;
    }

    /**
     * Node used to store an element and next reference.
     *
     * @param <E> element type
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * Creates a new node.
         *
         * @param data element to store
         */
        private Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
