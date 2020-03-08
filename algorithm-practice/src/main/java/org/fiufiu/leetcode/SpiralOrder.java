package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder(matrix);
        System.out.println(list);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    //my
    /*public List<Integer> spiralOrder(int[][] matrix) {
        int y = matrix.length;
        if (y<=0) {
            return Collections.emptyList();
        }
        int x = matrix[0].length;
        N = x*y;
        spiralOrder(matrix, 0, 0, 0, x, y, 0);
        return list;

    }
    int N=0;
    private List<Integer> list= new ArrayList<>();
    private void spiralOrder(int[][] matrix, int type, int xs, int ys, int xe, int ye, int count) {
        if (count==N) {
            return;
        }
        if (type == 0) {
            for (int i=xs;i<xe;i++) {
                list.add(matrix[ys][i]);
                count++;
            }
            spiralOrder(matrix, 1, xs, ys+1, xe, ye, count);
        } else if (type==1) {
            for (int i=ys;i<ye;i++) {
                list.add(matrix[i][xe-1]);
                count++;
            }
            spiralOrder(matrix, 2, xs, ys, xe-1, ye, count);
        } else if (type==2) {
            for (int i=xe-1;i>=xs;i--) {
                list.add(matrix[ye-1][i]);
                count++;
            }
            spiralOrder(matrix, 3, xs, ys, xe, ye-1,count);
        } else {
            for (int i=ye-1;i>=ys;i--) {
                list.add(matrix[i][xs]);
                count++;
            }
            spiralOrder(matrix, 0, xs+1,ys,xe,ye,count);
        }
    }*/
}
