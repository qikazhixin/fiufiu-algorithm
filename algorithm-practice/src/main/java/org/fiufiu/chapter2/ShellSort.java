package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class ShellSort extends BasicMethod {

    //希尔排序，是交换不相邻的元素，对数组局部进行排序，元素挪动更远；
    //因为插排是一位位挪动
    //使一个递增序列;例如3^k-1
    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        int h = 1;
        //递增序列
        while(h < len) {
            h = 3*h+1;
        }
        while(h>=1) {
            for (int i=h;i<len;i++) {
                for (int j=i;j>=h&&less(a[j],a[j-h]);j-=h) {
                    exchange(a,j,j-h);
                }
            }
            h/=3;
        }
        /*for(int i=h;i>0;i=(i-1)/3){
            for (int j=i;j<len;j++) {
                int t=j;
                while(t>=i) {
                    if(less(a[t], a[t-i])){
                        exchange(a, t, t-i);
                    }
                    t-=i;
                }
            }
        }*/
    }

    public static void main(String[] args) {
        ShellSort shell = new ShellSort();
        shell.executorQuick();
    }
}
