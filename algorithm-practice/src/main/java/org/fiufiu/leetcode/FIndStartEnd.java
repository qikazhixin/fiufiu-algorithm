package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class FIndStartEnd {

    public static void main(String[] args) {
        FIndStartEnd end = new FIndStartEnd();
//        int[] nums={5,7,7,8,8,10};
        int[] nums={1,4};
        int[] ints = end.searchRange(nums, 4);
        System.out.println("["+ints[0]+","+ints[1]+"]");
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[1]=searchRight(0,nums.length-1,nums,target);
        result[0]=searchLeft(0,nums.length-1,nums,target);
        return result;
    }

    public int searchRight(int lo, int hi, int[] nums, int target) {
        if(lo>hi||lo<0||hi>=nums.length) {
            return -1;
        }
        int mid=(lo+hi)/2;
        if (target==nums[mid]&&(mid+1>=nums.length||target<nums[mid+1])) {
            return mid;
        }
        if (target>=nums[mid]) {
            return searchRight(mid+1, hi,nums,target);
        } else {
            return searchRight(lo,mid-1,nums,target);
        }

    }

    public int searchLeft(int lo, int hi, int[] nums, int target) {
        if(lo>hi||lo<0||hi>=nums.length) {
            return -1;
        }
        int mid=(lo+hi)/2;
        if (target==nums[mid]&&(mid-1<0||target>nums[mid-1])) {
            return mid;
        }
        if (target<=nums[mid]) {
            return searchLeft(lo, mid-1,nums,target);
        } else {
            return searchLeft(mid+1,hi,nums,target);
        }

    }

    class Solution {
        // returns leftmost (or rightmost) index at which `target` should be
        // inserted in sorted array `nums` via binary search.
        private int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};

            int leftIdx = extremeInsertionIndex(nums, target, true);

            // assert that `leftIdx` is within the array bounds and that `target`
            // is actually in `nums`.
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }

            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

            return targetRange;
        }
    }


}
