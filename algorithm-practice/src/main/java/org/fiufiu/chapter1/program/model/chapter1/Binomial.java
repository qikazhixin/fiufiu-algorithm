package org.fiufiu.chapter1.program.model.chapter1;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Binomial {

    public static double b(int n, int k, double d) {
        if (n == 0 && k==0) {
            return 1.0;
        }
        if (n<0 || k<0) {
            return 0.0;
        }
        return (1-d)*b(n-1,k,d) + d*b(n-1,k-1,d);
    }
}
