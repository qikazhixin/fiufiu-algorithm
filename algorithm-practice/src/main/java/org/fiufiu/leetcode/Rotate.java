package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Rotate {

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate.rotate(matrix);

    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] tmp = new int[len][len];
        for (int i =0;i <len;i++) {
            for(int j=0;j<len;j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        for (int i =0;i <len;i++) {
            for(int j=0;j<len;j++) {
                matrix[i][j] = tmp[len-1-j][i];
            }
        }

    }
}
