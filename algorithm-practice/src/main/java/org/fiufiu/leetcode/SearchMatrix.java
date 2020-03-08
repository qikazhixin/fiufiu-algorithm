package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix matrix = new SearchMatrix();
        int[][] ins = {
                          {1,   3,  5,  7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 50}
                        };

        boolean b = matrix.searchMatrix(ins, 3);
        System.out.println(b);

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int j = matrix.length;
        if (j<=0) {
            return false;
        }
        int i = matrix[0].length;
        if (i<=0) {
            return false;
        }
        int i1 = binarySearch(matrix, 0, j-1, i - 1, target);
        if (i1 == -1) {
            return false;
        }
        int i2 = binarySearch(matrix[i1], 0, i - 1, target);
        if (i2 == -1) {
            return false;
        } else {
            return true;
        }

    }

    private int binarySearch(int[][] matrix, int lo, int hi, int N, int target) {
        if (lo>hi) {
            return -1;
        }
        int mid = (lo+hi)/2;
        if (target>=matrix[mid][0] && target<=matrix[mid][N]) {
            return mid;
        } else if(target<matrix[mid][0]) {
            return binarySearch(matrix, lo, mid-1, N, target);
        } else {
            return binarySearch(matrix, mid+1, hi, N, target);
        }
    }

    private int binarySearch(int[] matrix, int lo, int hi, int target) {
        if (lo>hi) {
            return -1;
        }
        int mid = (lo+hi)/2;
        if (target==matrix[mid]) {
            return mid;
        } else if(target<matrix[mid]) {
            return binarySearch(matrix, lo, mid-1, target);
        } else {
            return binarySearch(matrix, mid+1, hi, target);
        }
    }

}
