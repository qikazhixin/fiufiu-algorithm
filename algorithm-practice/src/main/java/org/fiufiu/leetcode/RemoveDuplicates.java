package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int i = duplicates.removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int res=0;
        int count =1;
        for (int i=1;i<len;i++) {
            //与前相等超过2次
            if (nums[i] == nums[res] && count == 0) {
                continue;
            } else if(nums[i]==nums[res]) {
                count--;
                nums[++res]=nums[i];
                continue;
            }
            count=1;
            nums[++res]=nums[i];
        }
        return res+1;
    }
}
