package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Sort912 {

    @Test
    public void test(){
        int[] ints = sortArray(new int[]{5, 2, 3, 1});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int lt=lo,i=lo+1,gt=hi;
        int num = nums[lo];
        while(i<=gt){
            int cmp=nums[i]- num;
            if(cmp<0){
                exch(nums, lt++,i++);
            } else if(cmp>0){
                exch(nums, i,gt--);
            } else {
                i++;
            }
        }
        sort(nums, lo, lt-1);
        sort(nums,gt+1,hi);

    }

    private void exch(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
