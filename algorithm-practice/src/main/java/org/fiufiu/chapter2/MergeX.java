package org.fiufiu.chapter2;

import edu.princeton.cs.algs4.Insertion;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MergeX extends Merge {

    private final static int CUTOFF = 5;

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo + CUTOFF>=hi) {
            //插入排序
            Insertion.sort(a,lo,hi);
            return;
        }
        int mid = (lo+hi)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if (!less(a[mid+1],a[mid])) {
//            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(a, lo, mid, hi);

    }

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        setAux(new Comparable[length]);
        sort(a, 0,  length-1);
    }


}
