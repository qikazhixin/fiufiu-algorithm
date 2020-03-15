package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        yl=grid.length;
        xl=grid[0].length;

        bs= new boolean[yl][xl];
        int max=0;
        for (int j=0;j<yl;j++) {
            for (int i=0;i<xl;i++) {
                max=Math.max(max, findNext(grid, i, j));
            }
        }
        return max;
    }

    boolean[][] bs;
    int yl;
    int xl;

    private int findNext(int[][] grid, int x,int y) {
        if (x<0||x>=xl||y<0||y>=yl) {
            return 0;
        }
        if (bs[y][x]) {
            return 0;
        }
        if (grid[y][x]==1) {
            bs[y][x]=true;
            return 1+findNext(grid, x+1, y) +
                    findNext(grid, x-1, y)+
                    findNext(grid, x, y-1)+
                    findNext(grid, x, y+1);
        }
        return 0;
    }
}
