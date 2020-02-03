package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MergeUB extends Merge {


    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        setAux(new Comparable[length]);
//        sort(a, 0,  length-1);
        mergeUB(a, 0, (0+length)/2, length-1);
    }


    //切分数组
    private void mergeUB(Comparable[] a, int lo, int mid, int hi) {
        if (lo>=hi) {
            return;
        }
        mergeUB(a, lo, (lo+mid)/2, mid);
        mergeUB(a, mid+1, (mid+1+hi)/2, hi);
        merge(a, lo, mid, hi);
    }

    //切分数组
    private void sort(Comparable[] a, int lo, int hi) {
        if (lo>=hi) {
            return;
        }
        int mid = (lo+hi)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);

    }

    public static void main(String[] args) {
        MergeUB mergeUB = new MergeUB();
        mergeUB.executorString("M E R G E S O R T E X A M P L E");
    }
}
