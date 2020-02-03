package org.fiufiu.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class HeapSort extends BasicMethod {

    Comparable[] pq;
    int n;

    @Override
    public void sort(Comparable[] a) {
        createSortedHeap(a);
        for (int i=n;i>=1;i--){
            exchange(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private void createSortedHeap(Comparable[] a) {
        int len = a.length;
        n=len;
        pq = new Comparable[len+1];
        for (int i=1;i<len+1;i++){
            pq[i]=a[i-1];
        }
        for(int i=len/2;i>=1;i--){
            sink(pq, i, len);
        }


    }

    private void sink(Comparable[] a, int target, int end) {
        int len = a.length;
        int i=target;
        while(i*2<=end) {
            int j=i*2;
            if(j<end&&less(a[j],a[j+1])){
                j++;
            }
            if (!less(a[i],a[j])){
                break;
            }
            exchange(a, i, j);
            i=j;
        }

    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.executorQuick();
        StdOut.println("Pq:");
        heapSort.show(heapSort.pq);
    }

}
