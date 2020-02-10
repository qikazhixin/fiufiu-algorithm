package org.fiufiu.chapter3;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class BinarySearchST<T extends Comparable<T>, E> implements OrderST<T, E> {

    private T[] keys;
    private E[] values;
    private int N;

    public BinarySearchST(int n) {

        keys = (T[]) new Comparable[n];
        values = (E[]) new Object[n];
    }

    @Override
    public void put(T key, E value) {
        int i = rank(key);
        if(i < N&& key.compareTo(keys[i])==0) {
            values[i]=value;
        } else {
            for (int j=N;j>i;j--) {
                keys[j]=keys[j-1];
                values[j]=values[j-1];
            }
            keys[i]=key;
            values[i]=value;
            N++;
        }


    }

    @Override
    public E get(T key) {
        if (isEmpty()) {
            return null;
        }
        int rank = rank(key);
        if(rank < N&& key.compareTo(keys[rank])==0) {
            return values[rank];
        }
        return null;
        /*int lo=0; int hi=N-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            T tmp = keys[mid];
            if (key.compareTo(tmp)==0) {
                return values[mid];
            } else if(key.compareTo(tmp)<0) {
                hi=mid-1;
            } else {
                lo=mid+1;
            }
        }
        return null;*/
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public T min() {
        return null;
    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public T floor(T key) {
        return null;
    }

    @Override
    public T ceiling(T key) {
        return null;
    }

    @Override
    public int rank(T key) {
        int lo=0; int hi=N-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp==0) {
                return mid;
            } else if(cmp<0) {
                hi=mid-1;
            } else {
                lo=mid+1;
            }
        }
        return lo;
    }

    private int rank(T key, int lo, int hi) {
       if(lo>hi) {
           return lo;
       }
       int mid = (lo+hi)/2;
       int cmp=key.compareTo(keys[mid]);
       if(cmp<0) {
           return rank(key,lo,mid-1);
       } else if(cmp>0){
           return rank(key,mid+1,hi);
       } else {
           return mid;
       }
        /*int i=lo;int j=hi;
        while(i<=j){
            int mid = (i+j)/2;
            T tmp = keys[mid];
            if (key.compareTo(tmp)==0) {
                return mid-lo;
            } else if(key.compareTo(tmp)<0) {
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return i-lo;*/
    }

    @Override
    public T select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(T lo, T hi) {
        return 0;
    }

    @Override
    public Iterable<T> keys(T lo, T hi) {
        return null;
    }

    @Override
    public Iterable<T> keys() {
        return null;
    }
}
