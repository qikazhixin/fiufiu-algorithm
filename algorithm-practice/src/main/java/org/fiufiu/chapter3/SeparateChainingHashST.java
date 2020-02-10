package org.fiufiu.chapter3;

import edu.princeton.cs.algs4.SequentialSearchST;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SeparateChainingHashST<T, E> {
    private int N;
    private int M;

    private SequentialSearchST<T, E>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        M = m;
        st=new SequentialSearchST[M];
        for (int i=0;i<M;i++) {
            st[i]=new SequentialSearchST<>();
        }
    }

    private int hash(T key) {
        return ((key.hashCode() & 0x7fffffff) % M);
    }
    public E get(T key) {
        return  st[hash(key)].get(key);
    }

    public void put(T key, E value) {
        st[hash(key)].put(key, value);
    }

}
