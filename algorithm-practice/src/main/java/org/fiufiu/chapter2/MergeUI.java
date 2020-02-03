package org.fiufiu.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MergeUI {

    private void mergeIndex(Comparable[] a, int[] index, int[] aux, int lo, int mid, int hi) {
        for (int k=lo;k<=hi;k++) {
            aux[k]=index[k];
        }
        int i=lo;int j=mid+1;
        for (int k=lo;k<=hi;k++) {
            if (i>mid) {
                index[k]=aux[j++];
            } else if(j>hi) {
                index[k]=aux[i++];
            } else if(less(a[aux[i]], a[aux[j]])) {
                index[k]=aux[i++];
            } else {
                index[k]=aux[j++];
            }
        }
        /*for (int k = lo; k <= hi; k++) {
            aux[k] = index[k];
        }
        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                    index[k] = aux[j++];
            else if (j > hi)                     index[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
            else                                 index[k] = aux[i++];
        }*/
    }

    private int[] sort(Comparable[] a) {
        int len = a.length;
        int [] index = new int[len];
        for (int i=0;i<len;i++){
            index[i]=i;
        }
        int [] aux = new int[len];
        sort(a, index, aux, 0, len-1);

        return index;
        /*int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        int[] aux = new int[n];
        sort(a, index, aux, 0, n-1);
        return index;*/
    }

    private void sort(Comparable[] a, int[] index, int[] aux, int lo, int hi) {
        if (lo>=hi) {
            return;
        }
        int mid=(lo+hi)/2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid+1, hi);
        mergeIndex(a, index, aux, lo, mid, hi);
        /*if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid + 1, hi);
        mergeIndex(a, index, aux, lo, mid, hi);*/
    }

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        MergeUI mergeUI = new MergeUI();
        String s = "M E R G E S O R T E X A M P L E";
        StdOut.println(s);
        String[] s1 = s.split(" ");
        int[] sort = mergeUI.sort(s1);
        mergeUI.show(sort);
    }

    private void show(int[] is) {
        for (int i=0;i<is.length;i++) {
            StdOut.print(is[i] + " ");
        }
    }
}
