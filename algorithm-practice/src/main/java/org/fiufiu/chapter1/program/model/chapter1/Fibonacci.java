package org.fiufiu.chapter1.program.model.chapter1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Fibonacci {

    public static long f1(int n) {
        long [] tmp = new long[n];
        if(n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (tmp[n-1] != 0) {
            return tmp[n-1];
        }
        long now = f(n - 1) + f(n - 2);
        tmp[n-1] = now;
        return now;
    }

    public static long f(int n) {

        if(n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return f(n - 1) + f(n - 2);

    }

    static long[] tmp;

    public static void pre() {
        tmp = new long[100];
        tmp[0] = 0;
        tmp[1] = 1;
        for (int i = 2; i<100; i++) {
            tmp[i] = tmp[i-1] + tmp[i-2];
        }
    }

    public static long f2(int n) {
        return tmp[n];
    }

    public static void main(String[] args) {
        pre();
        for (int n = 0; n < 100; n++) {
            StdOut.println(n + " " + f2(n));
        }
//        StdOut.println(50 + " " + f1(50));
    }
}
