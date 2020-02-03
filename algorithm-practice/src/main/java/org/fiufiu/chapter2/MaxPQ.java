package org.fiufiu.chapter2;

public abstract class MaxPQ<T extends Comparable<T>> {

    protected T[] pq;
    protected int size;
    public abstract void insert(T v);

    public abstract T max();

    public abstract T delMax();

    public abstract boolean isEmpty();

    public abstract int size();

    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    protected void exch(int i, int j){
        T t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    protected void swim(int k) {
        while(k>1&&less(k/2, k)) {
            exch(2/k, k);
        }
    }

    protected void sink(int k) {
        while (2*k<=size) {
            int j = 2*k;
            if(j<size&&less(j,j+1)) {
                j++;
            }
            if(!less(k, j)){
                break;
            }
            exch(k,j);
        }
    }
}
