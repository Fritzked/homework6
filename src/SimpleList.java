/**
 * Basic list operations.
 *
 * @param <E> type of elements stored
 */
public interface SimpleList<E> {
    int size();

    void add(E e);

    E get(int index);

    E set(int index, E e);
}
