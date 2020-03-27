package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindLengthOfLCIS {

    @Test
    public void test(){
        Assert.assertEquals(3, findLengthOfLCIS(new int[]{1,3,5,4,7}));
        Assert.assertEquals(1, findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int count=0;
        int pre=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<=nums[i-1]){
                count=Math.max(i-pre, count);
                pre=i;
            } else {

            }
        }
        count=Math.max(nums.length-pre, count);

        return count;
    }
}
