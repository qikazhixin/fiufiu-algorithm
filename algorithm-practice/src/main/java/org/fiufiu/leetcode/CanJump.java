package org.fiufiu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CanJump {

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
//        int[] ints = {2, 3, 1, 1, 4};
        int[] ints = {3,2,1,0,4};
        System.out.println(canJump.canJump(ints));
    }

    public boolean canJump(int[] nums) {
        int left=nums.length-1;
        for (int i=nums.length-2;i>=0;i--) {
            if (i+nums[i]>=left) {
                left=i;
            }
        }
        return left==0;

    }

    //自底向上的动态规划
    /*public boolean canJump(int[] nums) {
        boolean[] indices = new boolean[nums.length];
        canJump(nums, indices, nums.length-1);
        return indices[0];
    }

    void canJump(int[] nums, boolean[] indices, int target) {
        for (int i=target;i>=0;i--) {

            if (nums[i]>=target-i) {
                indices[i]=true;
                continue;
            }
            for (int j=1;j<=nums[i];j++) {
                if (indices[i+j]) {
                    indices[i]=true;
                    break;
                }
            }

        }

    }*/

    /*回溯
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        if (target<0) {
            return false;
        } else if(target==0) {
            return true;
        }
        return canJump(nums, 0, target);
    }

    boolean canJump(int[] nums, int now, int target) {
        int nowNum = nums[now];
        for (int i=1;i<=nowNum;i++) {
            int i1 = now + i;
            if(i1 ==target) {
                return true;
            } else if(i1>target) {
                return false;
            }

            boolean b = canJump(nums, i1, target);
            if (b) {
                return b;
            } else {
                continue;
            }
        }
        return false;
    }*/



}
