package org.fiufiu.chapter2;

import java.security.Key;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class HeapMaxPQ<T extends Comparable<T>> extends MaxPQ<T> {

    public HeapMaxPQ(int max) {
        pq = (T[])new Comparable[max+1];
    }


    @Override
    public void insert(T v) {
        pq[++size]=v;
        swim(size);
    }

    @Override
    public T max() {
        return pq[1];
    }

    @Override
    public T delMax() {
        T tmp= pq[1];
        exch(1, size--);
        pq[size+1]=null;
        sink(1);
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
}
