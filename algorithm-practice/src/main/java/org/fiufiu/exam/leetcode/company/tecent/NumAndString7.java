package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class NumAndString7 {

    @Test
    public void test(){
        Assert.assertEquals(2, threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }


    public int threeSumClosest(int[] nums, int target) {
        //思路,
        Arrays.sort(nums);

        int minGap = Integer.MAX_VALUE;
        int index=-1;
        for (int i = 0; i < nums.length - 2; i++) {
            int st = target - nums[i];
            int le = i+1;
            int ri = nums.length - 1;
            while(le<ri) {
                int i1 = nums[le] + nums[ri] -st;
                if (i1 == 0) {
                    return target;
                } else if(i1 > 0) {
                    minGap = Math.abs(i1)< Math.abs(minGap)?i1:minGap;
                    ri--;
                } else {
                    minGap = Math.abs(i1)< Math.abs(minGap)?i1:minGap;
                    le++;
                }
            }
        }
        
        return target+minGap;
    }
}
