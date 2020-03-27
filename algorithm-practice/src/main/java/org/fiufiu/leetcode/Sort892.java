package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Sort892 {

    @Test
    public void test(){
//        Assert.assertEquals(10, surfaceArea(new int[][]{{2}}));
        Assert.assertEquals(34, surfaceArea(new int[][]{{1,2},{3,4}}));
        Assert.assertEquals(16, surfaceArea(new int[][]{{1,0},{0,2}}));
        Assert.assertEquals(32, surfaceArea(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        Assert.assertEquals(46, surfaceArea(new int[][]{{2,2,2},{2,1,2},{2,2,2}}));
    }

    public int surfaceArea(int[][] grid) {
        int y = grid.length;
        if (y==0){
            return 0;
        }
        int x = grid[0].length;
        int sum = 0;
        int redu = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int count = grid[i][j];
                sum+= count;
                redu+=Math.max(0, count*2-2);
                if (count>0) {
                    //2个方向
                    if (j<x-1) {
                        redu += Math.min(count, grid[i][j+1])*2;
                    }
                    if (i<y-1) {
                        redu += Math.min(count, grid[i+1][j])*2;
                    }
                }
            }

        }
        return sum*6-redu;

    }
}
