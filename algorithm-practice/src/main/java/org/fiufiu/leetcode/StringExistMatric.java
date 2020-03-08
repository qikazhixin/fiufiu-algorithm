package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class StringExistMatric {

    public static void main(String[] args) {
        StringExistMatric matric = new StringExistMatric();
//        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] chars = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        char[][] chars = {{'a','a','a'},{'a','b','b'},{'a','b','b'},{'b','b','b'},{'b','b','b'},{'a','a','a'},{'b','b','b'},{'a','b','b'},{'a','a','b'},{'a','b','a'}};
//        char[][] chars = {{'A'}};
        String str = "AAB";
//        String str = "SEE";
//        String str = "ABCB";
//        String str = "aaaaaaaaaaaaa";
//        String str = "aabaaaabbb";

        System.out.println(matric.exist(chars, str));
    }


    public boolean exist(char[][] board, String word) {


        y = board.length;
        if(y==0) {
            return false;
        }
        x = board[0].length;
        if(x==0) {
            return false;
        }
        if(word.length()==0) {
            return true;
        }
        if (word.length()>x*y) {
            return false;
        }

        direct = new boolean[y][x];
        y = board.length;
        x = board[0].length;
        for (int i=0;i<x;i++) {
            for (int j=0;j<y;j++) {
                if (board[j][i]==word.charAt(0)) {
                    boolean b = backtrace(board, word, i, j, 0);
                    if (b) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean[][] direct;
    private int x;
    private int y;

    private boolean backtrace(char[][] board, String word, int fx, int fy, int i) {
        if (i>=word.length()) {
//            System.out.println("i=" + i);
            return true;
        }
        if (fx<0 || fx>=x || fy<0||fy>=y) {
            return false;
        }
        if (direct[fy][fx]==true) {
            return false;
        }
        if (board[fy][fx] != word.charAt(i)) {
            return false;
        }
        direct[fy][fx]=true;
            boolean b = backtrace(board, word, fx - 1, fy, i + 1);
            if (b) {
//                System.out.println("x=" + fx + "y" + fy);
                return true;
            }
            boolean b1 = backtrace(board, word, fx+1, fy, i+1);
            if (b1) {
//                System.out.println("x=" + fx + "y" + fy);
                return true;
            }

            boolean b2 = backtrace(board, word, fx, fy-1, i+1);
            if (b2) {
//                System.out.println("x=" + fx + "y" + fy);
                return true;
            }

            boolean b3 = backtrace(board, word, fx, fy+1, i+1);
            if (b3) {
//                System.out.println("x=" + fx + "y" + fy);
                return true;
            }
        direct[fy][fx]=false;
        return false;
    }
}
