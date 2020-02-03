package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SelectionSort extends BasicMethod {

    //选择排序就是把子序列最小的对象放到最前面
    @Override
    public void sort(Comparable[] a) {

        final int length = a.length;
        for(int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.executorQuick();
    }
}
