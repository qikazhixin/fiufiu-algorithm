package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class OtherSearch2 {

    public static void main(String[] args) {
        OtherSearch2 search2 = new OtherSearch2();
//        int[] nums = {2,5,6,0,0,1,2};
//        int[] nums = {1, 1};
        int[] nums = {1,3,1,1, 1};

        System.out.println(search2.search(nums, 3));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length<=0) {
            return false;
        }
        if (nums.length==1) {
            return target==nums[0];
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left<=right) {
             mid = (left+right)/2;
             if (nums[mid]==target) {
                 return true;
             }
             if (nums[mid] > nums[left]) {
                 if (target>=nums[left]&&target<=nums[mid]) {
                     right = mid;
                 } else {
                     left=mid+1;
                 }
             } else if (nums[mid] < nums[left]) {
                 if (target>=nums[mid]&&target<=nums[right]) {
                     left = mid;
                 } else {
                     right=mid-1;
                 }
             } else {
                 left++;
             }

        }
        return false;

    }


}
