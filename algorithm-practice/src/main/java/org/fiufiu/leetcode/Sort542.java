package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort542 {

    @Test
    public void test() {
        int[][] ints = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        int[][] ints1 = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(Arrays.deepToString(ints));
        System.out.println(Arrays.deepToString(ints1));
    }

    public int[][] updateMatrix(int[][] matrix) {
        //以0开始计算路径
        int lenY = matrix.length;
        if (lenY == 0) {
            return matrix;
        }
        int lenX = matrix[0].length;
        if (lenX == 0) {
            return matrix;
        }
        LinkedList<Node> ls =new LinkedList<>();
        int[][] res = new int[lenY][lenX];
        for (int i = 0; i < lenY; i++) {
            for (int j = 0; j < lenX; j++) {
                if (matrix[i][j] == 1) {
                    Node edge = isEdge(matrix, j, i);
                    if (edge != null) {
                        ls.add(edge);
                        res[i][j] = 1;
                    } else {
                        res[i][j] = -1;
                    }
                }
            }
        }
        int[] xx = {1, 0, -1, 0};
        int[] yy = {0, 1, 0, -1};
        while(!ls.isEmpty()) {
            Node node = ls.removeFirst();

            for (int i = 0; i < 4; i++) {
                Node change = change(res, node.x + xx[i], node.y + yy[i], res[node.y][node.x]);
                if (change != null) {
                    ls.add(change);
                }
            }

        }
        return res;

    }

    private Node change(int[][] res, int x, int y, int last) {
        int lenX = res[0].length;
        int lenY = res.length;
        if (x>=0&&x<lenX&&y>=0&&y<lenY&&res[y][x]==-1) {
            res[y][x]=last+1;
            return new Node(x, y);
        }
        return null;
    }

    private Node isEdge(int[][] matrix, int x, int y) {
        int lenX = matrix[0].length;
        int lenY = matrix.length;

        if (x+1>=0&&x+1<lenX&&matrix[y][x+1]==0) {
            return new Node(x, y);
        }
        if (x-1>=0&&x-1<lenX&&matrix[y][x-1]==0) {
            return new Node(x, y);
        }
        if (y+1>=0&&y+1<lenY&&matrix[y+1][x]==0) {
            return new Node(x, y);
        }
        if (y-1>=0&&y-1<lenY&&matrix[y-1][x]==0) {
            return new Node(x, y);
        }
        return null;
    }

    class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
