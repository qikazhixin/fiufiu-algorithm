package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

public class Search {

    @Test
    public void test() {
        Assert.assertEquals(4, search(new int[]{4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, search(new int[]{4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(-1, search(new int[]{1}, 3));
        Assert.assertEquals(0, search(new int[]{3,1}, 3));
        Assert.assertEquals(1, search(new int[]{3,1}, 1));
        Assert.assertEquals(2, search(new int[]{4,5,1,2,3}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length<=0) {
            return -1;
        }
        int lo=0;
        int hi=nums.length-1;
        int mid;
        if (nums[hi]>=nums[lo]) {
            mid = -1;
            return search(nums, target, lo, hi);
        } else {
            while(true) {
                mid=(lo+hi)/2;
                if (nums[mid]>nums[mid+1]) {
                    break;
                }
                if (nums[mid]>nums[lo]) {
                    lo=mid+1;
                } else {
                    hi=mid;
                }
            }
            System.out.println(mid);
            if (target==nums[0]) {
                return 0;
            } else if (target<nums[0]){
                return search(nums,target,mid+1, nums.length-1);
            } else {
                return search(nums,target,1,mid);
            }
        }


    }

    public int search(int[] nums, int target, int lo, int hi) {
        if (lo>hi){
            return -1;
        }
        int mid=(lo+hi)/2;
        if (target==nums[mid]){
            return mid;
        } else if(target<nums[mid]){
            return search(nums, target, lo, mid-1);
        } else {
            return search(nums, target, mid+1, hi);
        }

    }
}
