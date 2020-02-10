package org.fiufiu.chapter3;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public interface ST<T, E> {
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

    Iterable<T> keys();

}
