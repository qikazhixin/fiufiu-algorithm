package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Sort200 {

    @Test
    public void test() {
        char[][] actual = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Assert.assertEquals(1, numIslands(actual));
        char[][] actual2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        Assert.assertEquals(3, numIslands(actual2));
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        int leny = grid.length;
        if (leny == 0) {
            return res;
        }
        int lenx = grid[0].length;
        if (lenx == 0) {
            return res;
        }
        Stack<String> stack = new Stack<>();
        int[] xins = {1,0,-1,0};
        int[] yins = {0,1,0,-1};
        for (int i = 0; i < leny; i++) {
            for (int j = 0; j < lenx; j++) {
                if (grid[i][j] == '1') {
                    stack.add(i+":"+j);
                    while(!stack.isEmpty()) {
                        String pop = stack.pop();
                        String[] split = pop.split(":");
                        int x = Integer.valueOf(split[1]);
                        int y = Integer.valueOf(split[0]);
                        for (int k = 0; k < 4; k++) {
                            boolean b = check(grid, x + xins[k], y + yins[k]);
                            if (b) {
                                stack.add((y+yins[k]) + ":" + (x+xins[k]));
                            }
                        }
                    }
                    res++;
                }
            }
        }

        return res;
    }

    private boolean check(char[][] grid, int x, int y) {
        int leny = grid.length;
        int lenx = grid[0].length;
        if (x>=0&&x<lenx&&y>=0&&y<leny&&grid[y][x] == '1') {
            grid[y][x] = '2';
            return true;
        }
        return false;
    }
}
