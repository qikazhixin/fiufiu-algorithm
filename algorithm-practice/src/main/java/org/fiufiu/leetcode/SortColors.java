package org.fiufiu.leetcode;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SortColors {

    public static void main(String[] args) {
        SortColors colors = new SortColors();
//        int[] or = new int[]{2,0,2,1,1,0};
//        int[] or = new int[]{2,0,1};
        int[] or = new int[]{2,0,2,1,1,0};
//        int[] or = new int[]{0,0};
        colors.sortColors(or);
        System.out.println(Arrays.toString(or));
    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        int curr=0;
        int p0=0;
        int p2=len-1;
        while(curr<=p2) {
            if (nums[curr]==1) {


            } else if (nums[curr]==0) {
                exchange(nums,curr,p0);
                p0++;
            } else {
                exchange(nums,curr,p2);
                curr--;
                p2--;
            }
            curr++;
        }



    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
