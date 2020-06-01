package org.fiufiu.leetcode.interview;

import org.junit.Test;

import java.util.Arrays;

public class Interview0107 {

    @Test
    public void test() {
//        int[][] matrix = {{1,2},{3,4}};
//        rotate(matrix);
//        System.out.println(Arrays.deepToString(matrix));
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

    }

    public void rotate(int[][] matrix) {
        //以层来旋转，
        //先确定层数，
        int n = matrix.length;
        if(n == 0) {
            return;
        }
        int layer = n / 2;
        for (int i = 0; i < layer; i++) {
            rotateLayer(matrix, i, n);
        }
    }

    private void rotateLayer(int[][] matrix, int layer, int n) {
        //四个方向，我的话，先用一个数组tmp
        //然后在四次替换
        int[] tmp = matrix[layer].clone();
        for (int i = layer; i < n-1-layer; i++) {
            matrix[layer][i] = matrix[n-1-i][layer];
            matrix[n-1-i][layer] = matrix[n-1-layer][n-1-i];
            matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];
            matrix[i][n-1-layer] = tmp[i];
        }
    }
}
