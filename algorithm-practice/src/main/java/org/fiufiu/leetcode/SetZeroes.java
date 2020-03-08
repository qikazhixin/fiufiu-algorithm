package org.fiufiu.leetcode;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SetZeroes {

    public static void main(String[] args) {
        SetZeroes zeroes = new SetZeroes();
//        int[][] ints = {{1, 1, 1}, {1, 0, 1},{1,1,1}};
        //[0,1,2,0],
        //  [3,4,5,2],
        //  [1,3,1,5]
        int[][] ints = {{0, 1, 2, 0}, {3, 4, 5, 2},{1, 3, 1, 5}};
        zeroes.setZeroes(ints);
        System.out.println(Arrays.deepToString(ints));
    }

    public void setZeroes(int[][] matrix) {
        int y = matrix.length;
        if (y<=0) {
            return;
        }

        int x = matrix[0].length;

        boolean xf=false;
        boolean yf=false;
        if (matrix[0][0] == 0) {
            xf = true;
            yf = true;
        } else {
            for (int i=1;i<x;i++) {
                if (matrix[0][i] == 0) {
                    xf = true;
                    break;
                }
            }
            for (int j=1;j<y;j++) {
                if (matrix[j][0] == 0) {
                    yf = true;
                    break;
                }
            }
        }
        for (int i=1;i<x;i++) {
            for (int j=1;j<y;j++) {
                if (matrix[j][i] == 0) {
                    matrix[0][i]=0;
                    matrix[j][0]=0;
                }
            }
        }
        for (int i=1;i<x;i++) {
            if (matrix[0][i] == 0) {
                for (int j=1;j<y;j++) {
                    matrix[j][i]=0;
                }
            }
        }
        for (int j=1;j<y;j++) {
            if (matrix[j][0] == 0) {
                for (int i=1;i<x;i++) {
                    matrix[j][i]=0;
                }
            }
        }
        if (xf) {
            for (int i=0;i<x;i++) {
                matrix[0][i] = 0;
            }
        }
        if (yf) {
            for (int j=0;j<y;j++) {
                matrix[j][0] = 0;
            }
        }


    }
}
