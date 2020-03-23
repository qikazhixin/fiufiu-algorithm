package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Test;

public class MaxAreaOfIsland {

    @Test
    public void test() {
        int[][] grid={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};

        maxAreaOfIsland(grid);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int y = grid.length;
        if (y==0) {
            return max;
        }
        int x = grid[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[j][i]==1) {
                    max=Math.max(max, find(grid,j,i));
                }
            }
        }
        return max;
    }

    private int find(int[][] grid, int j, int i) {
        if (i<0||i>=grid[0].length||j<0||j>=grid.length) {
            return 0;
        }
        if (grid[j][i]==0) {
            return 0;
        }
        grid[j][i]=0;
        return 1+find(grid,j,i+1)+find(grid,j,i-1)+find(grid,j-1,i)+find(grid,j+1,i);

    }
}
