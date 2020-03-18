package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    @Test
    public void test() {
//        Assert.assertEquals(new int[][] {{-1, 0, 1},{-1, -1, 2}},
//                threeSum(new int[]{-1, 0, 1, 2, -1, -4}).stream().map(integers -> integers.toArray()).toArray());
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(threeSum(new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set1 =new HashSet<>();
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if (set1.contains(nums[i])) {
                continue;
            }
            Map<Integer, Boolean> set =new HashMap<>();
            for (int j=i+1;j<nums.length;j++) {
                if (set1.contains(nums[j])) {
                    continue;
                }
                if (set.get(nums[j]) != null) {
                    if(set.get(nums[j])) {
                       continue;
                    }
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(0-nums[i]-nums[j]);
                    ls.add(tmp);
                    set.put(0-nums[i]-nums[j], true);
                    set.put(nums[j], true);
                } else {
                    set.put(0 - nums[i] - nums[j], false);
                }
            }
            set1.add(nums[i]);
        }
        return ls;
    }
}
