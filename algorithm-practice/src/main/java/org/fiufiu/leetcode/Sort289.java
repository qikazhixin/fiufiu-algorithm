package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort289 {

    @Test
    public void test() {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void gameOfLife(int[][] board) {
        int[][] tmp= board.clone();
        int t=0;
        for (int[] i:board) {
            tmp[t++]=i.clone();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=state(tmp, j ,i);
            }
        }
    }

    private int state(int[][] board, int x,int y){
        int start = board[y][x];
        int count=0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if(i>=0&&i<board[0].length&&j>=0&&j<board.length){
                    count+=board[j][i];
                }
            }
        }
        count-=start;
        if (start==0&&count==3){
            return 1;
        } else if(start==1&&count<2) {
            return 0;
        } else if(start==1&&count>3) {
            return 0;
        } else {
            return start;
        }
    }
}
