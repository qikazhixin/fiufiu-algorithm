package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Quick3Way extends QuickSort {

    public void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) {
            return;
        }
        int lt=lo;int i=lo+1;int gt=hi;
        Comparable v=a[lo];
        while(i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0){
                exchange(a, lt++, i++);
            } else if(cmp>0){
                exchange(a, i, gt--);
            } else {
                i++;
            }
        }

    }
}
