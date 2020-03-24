package org.fiufiu.leetcode.interview;

import org.junit.Assert;
import org.junit.Test;

public class Interview1716 {

    @Test
    public void test() {
        Assert.assertEquals(4, massage(new int[]{1,2,3,1}));
        Assert.assertEquals(12, massage(new int[]{2,7,9,3,1}));
        Assert.assertEquals(12, massage(new int[]{2,1,4,5,3,1,1,3}));
    }

    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if(len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] ans = new int[len];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            ans[i] = Math.max(ans[i-2] + nums[i], ans[i-1]);
        }
        return ans[len-1];
    }
}
