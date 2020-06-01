package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class NumAndString1 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0,1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{2,3}, twoSum(new int[]{2, 4, 5, 7, 9}, 12));
        Assert.assertArrayEquals(new int[]{2,3}, twoSum(new int[]{2, 4, 5, 7, 9, 13}, 12));
    }



    //问题，数组的引用变了；引用排序（）
    public int[] twoSum(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //双指针逼近法
        int lo = 0;
        int hi = nums.length - 1;
        while (hi < nums.length && hi > lo) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                int[] res = new int[2];
                res[0] = lo;
                res[1] = hi;
                return res;
            }
        }

        return null;



    }
}
