package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class OtherSearcher {

    public static void main(String[] args) {
        OtherSearcher searcher = new OtherSearcher();
//        int[] nums={4,5,6,7,8,1,2,3};
//        int[] nums={3,1};
        int[] nums={2,5,6,0,0,1,2};
        int search = searcher.search(nums, 0);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        if(nums.length<1) {
            return -1;
        }
        return search(0, nums.length-1, nums,target);
    }

    public int search(int lo, int hi, int[] nums, int target) {
        boolean left=false;
        if (lo>hi) {
            return -1;
        }
        int mid = (lo+hi)/2;
        if (nums[lo]>nums[hi]) {
            //逆序
            if (target>nums[hi] && target<nums[lo]) {
                return -1;
            }

            if (target==nums[mid]) {
                return mid;
            }
            if(target==nums[hi]) {
                return hi;
            }
            if (target==nums[lo]) {
                return lo;
            }
            if (nums[mid]>nums[lo]) {
                //左是顺序
                left=true;
            }
            if (target>nums[mid]) {
                if (left) {
                    return search(mid+1,hi,nums,target);
                } else {
                    if (target>nums[hi]) {
                        return search(lo,mid-1,nums,target);
                    } else {
                        return search(mid+1,hi,nums,target);
                    }
                }
            } else {
                if (!left) {
                    return search(lo,mid-1,nums,target);
                } else {
                    if (target>nums[lo]) {
                        return search(lo,mid-1,nums,target);
                    } else {
                        return search(mid+1,hi,nums,target);
                    }
                }
            }

        } else {
            if (target<nums[lo] || target>nums[hi]) {
                return -1;
            } else {
                if (target==nums[mid]) {
                    return mid;
                } else if (target>nums[mid]) {
                    return search(mid+1,hi,nums,target);
                } else {
                    return search(lo,mid-1,nums,target);
                }
            }
        }



    }

    //anwser leetcode
    /*class Solution {
        int [] nums;
        int target;

        public int find_rotate_index(int left, int right) {
            if (nums[left] < nums[right])
                return 0;

            while (left <= right) {
                int pivot = (left + right) / 2;
                if (nums[pivot] > nums[pivot + 1])
                    return pivot + 1;
                else {
                    if (nums[pivot] < nums[left])
                        right = pivot - 1;
                    else
                        left = pivot + 1;
                }
            }
            return 0;
        }

        public int search(int left, int right) {
    *//*
    Binary search
    *//*
            while (left <= right) {
                int pivot = (left + right) / 2;
                if (nums[pivot] == target)
                    return pivot;
                else {
                    if (target < nums[pivot])
                        right = pivot - 1;
                    else
                        left = pivot + 1;
                }
            }
            return -1;
        }

        public int search(int[] nums, int target) {
            this.nums = nums;
            this.target = target;

            int n = nums.length;

            if (n == 0)
                return -1;
            if (n == 1)
                return this.nums[0] == target ? 0 : -1;

            int rotate_index = find_rotate_index(0, n - 1);

            // if target is the smallest element
            if (nums[rotate_index] == target)
                return rotate_index;
            // if array is not rotated, search in the entire array
            if (rotate_index == 0)
                return search(0, n - 1);
            if (target < nums[0])
                // search in the right side
                return search(rotate_index, n - 1);
            // search in the left side
            return search(0, rotate_index);
        }
    }*/

}
