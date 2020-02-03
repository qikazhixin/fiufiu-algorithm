package org.fiufiu.chapter2;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public abstract class Merge extends BasicMethod{

    private Comparable[] aux;

    public void setAux(Comparable[] aux) {
        this.aux = aux;
    }

    //将子数组[lo-mid]和[mid-hi]归并成一个有序数组
    protected void merge(Comparable[] a, int lo, int mid, int hi) {
        int i=lo;int j=mid+1;
        for (int k=lo;k<=hi;k++) {
            aux[k] = a[k];
        }
        for (int k=lo;k<=hi;k++){
            if(i>mid) {
                a[k]=aux[j++];
            } else if(j>hi) {
                a[k]=aux[i++];
            } else if(less(aux[i], aux[j])) {
                a[k]=aux[i++];
            } else {
                a[k]=aux[j++];
            }
        }
    }

    protected void mergeD(Comparable[] a, int lo, int mid, int hi) {
        int i=lo;int j=hi;
        for (int k=lo;k<=mid;k++) {
            aux[k] = a[k];
        }
        for (int k=mid+1;k<=hi;k++) {
            aux[k]=a[mid+1+hi-k];
        }

        for (int k=lo;k<=hi;k++) {
            if (less(aux[i],aux[j])) {
                a[k]=aux[i++];
            } else {
                a[k]=aux[j--];
            }

        }
    }

    protected void mergeIndex(Comparable[] a,int[] index, int[]aux, int lo, int mid, int hi) {
        int i=lo;int j=mid+1;
        for (int k=lo;k<=hi;k++) {
            aux[k] = index[k];
        }
        for (int k=lo;k<=hi;k++){
            if(i>mid) {
                index[k]=aux[j++];
//                a[k]=aux[j++];
            } else if(j>hi) {
                index[k]=aux[i++];
//                a[k]=aux[i++];
            } else if(less(a[aux[i]], a[aux[j]])) {
                index[k]=aux[i++];
//                a[k]=aux[i++];
            } else {
                index[k]=aux[j++];
//                a[k]=aux[j++];
            }
        }
    }
}
