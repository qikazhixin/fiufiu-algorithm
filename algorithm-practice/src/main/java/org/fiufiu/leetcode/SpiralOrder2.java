package org.fiufiu.leetcode;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SpiralOrder2 {

    public static void main(String[] args) {
        SpiralOrder2 order2 = new SpiralOrder2();
        int[][] ints = order2.generateMatrix(0);
        System.out.println(Arrays.deepToString(ints));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start=1;
        int N = n * n;
        int xs=0, xe=n-1, ys=0, ye=n-1;
        while(start <= N) {
            for (int i=xs;i<=xe;i++) {
                res[ys][i] = start++;
            }
            for (int j=ys+1;j<=ye;j++) {
                res[j][xe] = start++;
            }
            for (int i=xe-1;i>=xs;i--) {
                res[ye][i] = start++;
            }
            for (int j=ye-1;j>ys;j--) {
                res[j][xs] = start++;
            }
            xs++;
            xe--;
            ys++;
            ye--;
        }
        return res;
    }
}
