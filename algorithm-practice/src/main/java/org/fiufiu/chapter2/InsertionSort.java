package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class InsertionSort extends BasicMethod {

    //插入排序就是将对象放到指定的位置，
    //当前位置的对象一直于前置的对象对比；
    //1. 如果大，则不动
    //2.如果小，则向前置换
    @Override
    public void sort(Comparable[] a) {
        final int length = a.length;
        for (int i=1; i<length; i++) {
            /*int j=i;
            while (j>0&&less(a[j],a[j-1])){
                exchange(a, j, j-1);
                j--;
            }*/
            for (int j=i; j>0&&less(a[j],a[j-1]); j--) {
                exchange(a, j, j-1);

            }
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.executorQuick();
    }
}
