package org.fiufiu.chapter1.program.model.chapter5;


import edu.princeton.cs.algs4.Insertion;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MSD {

    public static void main(String[] args) {
        String[] s = {"she", "shell", "seashells", "by", "the", "sea", "she", "are", "surely"};
        sort(s);
        System.out.println();
    }

    private static int R = 256;
    private static final int M = 1;
    private static String[] aux;
    private static int charAt(String s, int d) {
        if (d<s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    private static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if(hi<=lo+M) {
//            Insertion.sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+2];
        for (int i=lo;i<=hi;i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r =0;r<R+1;r++) {
            count[r+1]+=count[r];
        }
        for (int i=lo;i<=hi;i++){
            aux[count[charAt(a[i],d)+1]++]=a[i];
        }
        for (int r=0;r<R;r++) {
            sort(a,lo+count[r],lo+count[r+1]-1,d+1);
        }
        /*if (hi<=lo+M) {
            return;
        }
        int[] count = new int[R];
        for (int i=lo;i<hi;i++) {
            count[charAt(a[i], d)+1]++;
        }
        for (int r=0;r<R-1;r++) {
            count[r+1]=count[r+1]+count[r];
        }
        for (int i=lo;i<hi;i++) {
            int i1 = count[charAt(a[i], d)]++;
            aux[i1+lo]=a[i];
        }
        for (int i=lo;i<hi;i++) {
            a[i]=aux[i];
        }
        for (int r=0;r<R;r++) {
            sort(a, lo+count[r], lo+count[r+1], d+1);
        }*/
    }
}
