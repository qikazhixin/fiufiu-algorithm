package org.fiufiu.chapter1.program.model.chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class BinarySearch {

    //二分查找数组必须有序
    public static int rank(int key, int[] a) {
        int len = a.length;
        int l = 0;
        int r = len;
        int h;

        while(l<r) {
            h = (l + r)/2;
            if(key == a[h]) {
                return key;
            } else if (key < a[h]) {
                r = h;
            } else {
                l = h;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("start");
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }
}
