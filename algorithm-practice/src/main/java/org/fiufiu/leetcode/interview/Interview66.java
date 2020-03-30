package org.fiufiu.leetcode.interview;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Interview66 {

    public int lastRemaining(int n, int m) {
        int f=0;
        for (int i=2;i<=n;i++){
            f=(f+m)%i;
        }
        return f;
    }
}
