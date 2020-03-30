package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindKthLargest {

    @Test
    public void test() {
        Assert.assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        Assert.assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        //快选
        //基于快排
        int i = quickSelect(nums, 0, nums.length - 1, nums.length - k);

        return i;
    }

    private int  quickSelect(int[] nums, int lo, int hi, int k){
//        if ()
        if (lo>hi){
            return -1;
        }
        int first=lo;
        int last=hi;
        int tmp=nums[lo];
        while(lo<=hi){
            if (nums[lo]<=tmp){
                lo++;
                continue;
            } else {
                while(nums[hi]>tmp){
                    hi--;
                }
            }
            if (lo>hi){
                break;
            }
            int tmp1=nums[lo];
            nums[lo]=nums[hi];
            nums[hi]=tmp1;
        }

        nums[first]=nums[lo-1];
        nums[lo-1]=tmp;
        if (k==lo-1){
            return nums[lo-1];
        } else if (k>lo-1){
            return quickSelect(nums,lo,last,k);
        } else {
            return quickSelect(nums,first,lo-1-1,k);
        }
    }

    //import java.util.Random;
    //class Solution {
    //  int [] nums;
    //
    //  public void swap(int a, int b) {
    //    int tmp = this.nums[a];
    //    this.nums[a] = this.nums[b];
    //    this.nums[b] = tmp;
    //  }
    //
    //
    //  public int partition(int left, int right, int pivot_index) {
    //    int pivot = this.nums[pivot_index];
    //    // 1. move pivot to end
    //    swap(pivot_index, right);
    //    int store_index = left;
    //
    //    // 2. move all smaller elements to the left
    //    for (int i = left; i <= right; i++) {
    //      if (this.nums[i] < pivot) {
    //        swap(store_index, i);
    //        store_index++;
    //      }
    //    }
    //
    //    // 3. move pivot to its final place
    //    swap(store_index, right);
    //
    //    return store_index;
    //  }
    //
    //  public int quickselect(int left, int right, int k_smallest) {
    //    /*
    //    Returns the k-th smallest element of list within left..right.
    //    */
    //
    //    if (left == right) // If the list contains only one element,
    //      return this.nums[left];  // return that element
    //
    //    // select a random pivot_index
    //    Random random_num = new Random();
    //    int pivot_index = left + random_num.nextInt(right - left);
    //
    //    pivot_index = partition(left, right, pivot_index);
    //
    //    // the pivot is on (N - k)th smallest position
    //    if (k_smallest == pivot_index)
    //      return this.nums[k_smallest];
    //    // go left side
    //    else if (k_smallest < pivot_index)
    //      return quickselect(left, pivot_index - 1, k_smallest);
    //    // go right side
    //    return quickselect(pivot_index + 1, right, k_smallest);
    //  }
    //
    //  public int findKthLargest(int[] nums, int k) {
    //    this.nums = nums;
    //    int size = nums.length;
    //    // kth largest is (N - k)th smallest
    //    return quickselect(0, size - 1, size - k);
    //  }
    //}
    //

}
