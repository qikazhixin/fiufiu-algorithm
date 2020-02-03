package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MergeBU extends Merge {

    @Override
    public void sort(Comparable[] a) {
        final int len = a.length;
        setAux(new Comparable[len]);
        /*int sz=1;
        while(sz<len) {
            int last=0;
            for (int i=0;i<len-sz;i+=sz+sz) {
                last=i;
                merge(a,i,(i+i+sz)/2, i+sz+sz-1);
            }
            merge(a, last, (last+len-1)/2,len-1);
            sz*=2;
        }*/
        for (int sz=1;sz<len;sz*=2){
            for (int lo=0;lo<len-sz;lo+=sz+sz){
                merge(a,lo,lo+sz-1,Math.min(len-1,lo+sz+sz-1));
            }
        }
    }

    public static void main(String[] args) {

        MergeBU mergeBU = new MergeBU();
        mergeBU.executorString("M E R G E S O R T E X A M P L E");
    }
}
