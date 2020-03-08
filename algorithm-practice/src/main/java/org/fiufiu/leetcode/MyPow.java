package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.0,8));
    }


    /*private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }*/


    public double myPow(double x, int n) {
        long N = n;
        double res = x;
        double tmp = 1;
        if (N<0) {
            N=-N;
            res = 1/x;
        }
        for (Long i=N;i>0;i/=2) {
            if (i%2==1) {
                tmp=tmp*res;
            }
            res=res*res;


        }
        return tmp;
    }
}
