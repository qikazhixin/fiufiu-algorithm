package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Merge {

    @Test
    public void test() {
        merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]<o2[0]) {
                return -1;
            } else if (o1[0]>o2[0]){
                return 1;
            } else {
                return 0;
            }
        });

        List<int[]> ls = new ArrayList<>();
        int start=intervals[0][0];
        int pre=intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<=pre+1) {
                pre=Math.max(intervals[i][1], pre);
            } else {
                ls.add(new int[]{start, pre});
                start=intervals[i][0];
                pre=intervals[i][1];
            }
        }
        ls.add(new int[]{start, pre});

        int[][] res = new int[ls.size()][2];
        int i=0;
        Iterator<int[]> iterator = ls.iterator();
        while (iterator.hasNext()) {
            res[i++]=iterator.next();
        }
        return res;
    }
}
