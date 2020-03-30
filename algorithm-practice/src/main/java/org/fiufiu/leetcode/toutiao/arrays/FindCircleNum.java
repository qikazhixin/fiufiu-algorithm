package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class FindCircleNum {

    @Test
    public void test(){
//        Assert.assertEquals(2, findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));
//        Assert.assertEquals(1, findCircleNum(new int[][]{{1,1,0}, {1,1,1}, {0,1,1}}));
        Assert.assertEquals(1, findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }

    public int findCircleNum(int[][] M) {
        int y = M.length;
        int x=M[0].length;
        int count=0;
        boolean[] ans = new boolean[y];

        for (int i = 0; i < y; i++) {
            if (ans[i]) {
                continue;
            }
            count++;
            Queue<Integer> set = new LinkedList<>();
            set.add(i);
            ans[i]=true;
            while(!set.isEmpty()){
                Integer poll = set.poll();
                for (int j = 0; j < x; j++) {
                    if (ans[j]) {
                        continue;
                    }
                    if (M[poll][j] == 1) {
                        ans[j] = true;
                        set.add(j);
                    }
                }
            }
        }
        return count;

    }
}
