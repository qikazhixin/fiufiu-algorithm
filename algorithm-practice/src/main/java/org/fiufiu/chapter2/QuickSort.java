package org.fiufiu.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class QuickSort extends BasicMethod {


    //快速排序的基本思想是：将数组切分成两部分，左边比基准小，右边比基准大
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //切换到插入排序
        if (lo>=hi) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a, lo, partition -1);
        sort(a, partition + 1, hi);
    }

    //快排的切分思想是：以首个元素为基准，
    // 左边的指针从lo开始与基准比较，直到找到第一个比基准大的元素
    // 右边的元素从hi开始与基准比较，知道找到第一个比基准小的元素
    //交换第一个元素和当前i前一个元素
    private int partition(Comparable[] a, int lo, int hi) {
        /*int i=lo+1;int j=hi;
        int bas=lo;
        while(i<j){
            while(less(a[i],a[bas])) {
                i++;
            }
            while(less(a[bas],a[j])) {
                j--;
            }
            if(i<j) {
                exchange(a, i, j);
            }
        }
        exchange(a, lo, j);
        return j*/
        int i=lo;int j=hi+1;
        Comparable v=a[lo];
        while (true) {
            while (less(a[++i],v)) {
                if (i==hi) {
                    break;
                }
            }
            while (less(v,a[--j])) {
                if (j==lo) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            exchange(a,i,j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        String s = "K R A T E L E P U I M Q C X O S";
        QuickSort sort = new QuickSort();
        sort.executorString(s);

    }
}
