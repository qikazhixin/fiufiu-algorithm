package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Sort999 {

    @Test
    public void test() {
        Assert.assertEquals(3, numRookCaptures(new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}

        }));
    }


    public int numRookCaptures(char[][] board) {
        int x=0,y=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    y=i;x=j;
                }
            }
        }
        int count=0;
        int[] dx= {0, 1, 0, -1};
        int[] dy={1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            for (int step=0;;step++){
                int tx=x+step*dx[i];
                int ty=y+step*dy[i];
                if (tx<0||tx>=8||ty<0||ty>=8||board[ty][tx]=='B') {
                    break;
                }
                if (board[ty][tx]=='p'){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
