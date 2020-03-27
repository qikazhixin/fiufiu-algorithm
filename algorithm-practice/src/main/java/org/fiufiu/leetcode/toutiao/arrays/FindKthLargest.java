package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindKthLargest {

    @Test
    public void test() {
        Assert.assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        Assert.assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        return 0;
    }
}
