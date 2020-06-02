package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Sort1248 {

    @Test
    public void test() {
        Assert.assertEquals(2, numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
        Assert.assertEquals(0, numberOfSubarrays(new int[]{2,4,6}, 1));
        Assert.assertEquals(16, numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }


    public int numberOfSubarrays(int[] nums, int k) {
//        int[] evenum = new int[2];
        int res = 0;
        List<Integer> ls = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            } else {
                ls.add(count);
                count = 0;
            }
        }
        ls.add(count);
        Integer[] evenum = new Integer[ls.size()];
        ls.toArray(evenum);
        for (int i = 0; i + k < evenum.length; i++) {
            res += (evenum[i] + 1)*(evenum[i+k] + 1);
        }
        return res;
    }
}
