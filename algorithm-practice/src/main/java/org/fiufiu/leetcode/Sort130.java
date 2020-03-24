package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Sort130 {

    @Test
    public void test() {
        char[][] board = new char[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[j][i] = 'X';
            }
        }
        board[3][1]='O';
        board[3][2]='O';
        board[2][0]='O';
        board[1][2]='O';

        System.out.println(Arrays.deepToString(board));
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        lenx = board[0].length-1;
        leny = board.length-1;
        for (int i = 0; i <= lenx; i++) {
            recur(board, i, 0);
            recur(board, i, leny);
        }
        for (int i = 1; i < leny; i++) {
            recur(board,0,i);
            recur(board,lenx,i);
        }
        for (int i = 0; i <= lenx; i++) {
            for (int j = 0; j <= leny; j++) {
                if (board[j][i] == 'I') {
                    board[j][i] = 'O';
                } else if(board[j][i] == 'O') {
                    board[j][i] = 'X';
                } else {
                }
            }
        }
    }
    int lenx;
    int leny;
    public void recur(char[][] board, int x,int y) {
        if (x<0||x>lenx||y<0||y>leny) {
            return;
        }
        if (board[y][x]=='X') {
            return;
        } else if(board[y][x]=='I') {
            return;
        } else {
            board[y][x] = 'I';
            recur(board, x+1, y);recur(board, x-1, y);
            recur(board, x, y+1);recur(board, x, y-1);

        }

    }
}
