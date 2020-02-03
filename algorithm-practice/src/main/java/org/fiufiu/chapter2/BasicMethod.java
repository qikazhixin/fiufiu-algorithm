package org.fiufiu.chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public abstract class BasicMethod {

    public abstract void sort(Comparable[]a);

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public void executor() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            String[] s1 = s.split(" ");
            sort(s1);
            assert isSorted(s1);
            show(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String quick = "S O R T E X A M P L E";

    public void executorQuick() {
        StdOut.println(quick);
        String s = quick;
        String[] s1 = s.split(" ");
        sort(s1);
        assert isSorted(s1);
        show(s1);
    }

    public void executorString(String str) {
        StdOut.println(str);
        String s = str;
        String[] s1 = s.split(" ");
        sort(s1);
        assert isSorted(s1);
        show(s1);
    }
}
