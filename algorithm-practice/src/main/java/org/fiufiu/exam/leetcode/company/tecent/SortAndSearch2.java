package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SortAndSearch2 {

    @Test
    public void test() {
        Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(-1, search(new int[]{4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(0, search(new int[]{1}, 1));
        Assert.assertEquals(0, search(new int[]{3,1}, 3));
        Assert.assertEquals(0, search(new int[]{3,5,1}, 3));
    }

    public int search(int[] nums, int target) {
        //分治
        //先把二分这个值找出来，在二分
        if (nums.length==0) {
            return -1;
        }
        int lo=0,hi=nums.length-1;
        int index=0;
        if (nums[hi]>=nums[lo]) {
            return search(nums, target, lo, hi);
        } else {
            lo=1;
            while(lo<=hi) {
                int mid = (lo+hi)/2;
                if (nums[mid]<nums[mid-1]) {
                    index = mid;
                    break;
                } else if (nums[mid]<=nums[hi]){
                    hi=mid-1;
                } else {
                    lo=mid+1;
                }
            }
        }
        if (target < nums[index] || target > nums[index-1]) {
            return -1;
        } else {
            if (target>=nums[0]) {
                return search(nums, target, 0, index-1);
            } else {
                return search(nums, target, index, nums.length-1);
            }
        }
    }

    private int search(int[] nums, int target, int lo ,int hi) {
        if (lo>hi) {
            return -1;
        }
        int mid=(lo+hi)/2;
        if (target==nums[mid]) {
            return mid;
        } else if (target>nums[mid]) {
            return search(nums, target, mid+1, hi);
        } else {
            return search(nums, target, lo, mid-1);
        }
    }

}
