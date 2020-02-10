package org.fiufiu.chapter3;

public interface OrderST<T extends Comparable<T>, E> {

    void put(T key, E value);

    E get(T key);

    default void delete(T key) {
        put(key, null);
    }

    default boolean contains(T key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size()==0;
    }

    int size();

    T min();

    T max();

    T floor(T key);

    T ceiling(T key);

    int rank(T key);

    T select(int k);

    void deleteMin();

    void deleteMax();

    int size(T lo, T hi);

    Iterable<T> keys(T lo, T hi);

    Iterable<T> keys();
}
