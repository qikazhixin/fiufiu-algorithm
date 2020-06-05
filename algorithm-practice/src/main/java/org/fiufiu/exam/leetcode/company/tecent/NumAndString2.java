package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Test;

import java.util.Arrays;

//Sort4
public class NumAndString2 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(divideMiddle(new int[]{5, 1, 4, 3, 6, 2, 8, 9}, 0, 7)));
        System.out.println(Arrays.toString(divideMiddle(new int[]{5}, 0, 0)));
        System.out.println(Arrays.toString(divideMiddle(new int[]{5, 1, 4, 3}, 0, 3)));
    }

    @Test
    public void test2() {
        System.out.println(quickFindSortK(new int[]{5, 1, 4, 3, 6, 2, 8, 9}, 3, 0, 7));
        System.out.println(quickFindSortK(new int[]{5}, 0, 0, 0));
        System.out.println(quickFindSortK(new int[]{5, 1, 4, 3}, 1, 0, 3));
    }

    @Test
    public void test3() {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    public void test4() {
//        System.out.println(findMedianSortedArrays2(new int[]{1, 3, 5, 7, 9}, new int[]{2, 8, 9, 10}));
//        System.out.println(findMedianSortedArrays2(new int[]{1, 3, 5, 7, 9}, new int[]{2, 8, 9, 10, 11, 12}));
//        System.out.println(findMedianSortedArrays2(new int[]{1, 3}, new int[]{2}));
//        System.out.println(findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(findMedianSortedArrays2(new int[]{3}, new int[]{-2, -1}));
        System.out.println(findMedianSortedArrays2(new int[]{1}, new int[]{2, 3, 4, 5, 6}));
    }

    //官方代码
    /*class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                double median = getKthElement(nums1, nums2, midIndex + 1);
                return median;
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return median;
            }
        }

        public int getKthElement(int[] nums1, int[] nums2, int k) {
            *//* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             * 这里的 "/" 表示整除
             * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
             * 这样 pivot 本身最大也只能是第 k-1 小的元素
             * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             *//*

            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kthElement = 0;

            while (true) {
                // 边界情况
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                // 正常情况
                int half = k / 2;
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }

    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    //官方的想法，二分
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        if (total%2 == 0) {
            int k1 = total/2;
            int k2 = total/2 + 1;
            double s1 = (double)findSortK(nums1, 0, nums2, 0, k1);
            double s2 = (double)findSortK(nums1, 0, nums2, 0, k2);
            return (s1 + s2)/2;
        } else {
            int k = total/2 + 1;
            return findSortK(nums1, 0, nums2, 0, k);
        }

    }

    //k是指第几个，从1开始的那种
    private int findSortK(int[] nums1, int l1, int[] nums2, int l2, int k) {
        if (l1 >= nums1.length) {
            return nums2[l2 + k -1];
        }
        if (l2 >= nums2.length) {
            return nums1[l1 + k -1];
        }
        if (k <= 1) {
            return nums1[l1]>nums2[l2] ? nums2[l2]:nums1[l1];
        }
        //步长
        int i = k/2 - 1;
        //
        if (l1 + i >= nums1.length) {
            i = nums1.length - 1 - l1;
        } else if (l2 + i >= nums2.length) {
            i = nums2.length - 1 - l2;

        }

        int i1 = nums1[l1 + i];
        int i2 = nums2[l2 + i];
        //结束条件
        //处理越界的情况
        if (i1 <= i2) {
            return findSortK(nums1, l1 + i + 1, nums2, l2, k - (i+1));
        } else {
            return findSortK(nums1, l1, nums2, l2 + i + 1, k - (i+1));
        }
    }

    //我用的快找；快排延伸出来的快速查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //快选
        //找到第k大的
        //虚拟的指针
        int pre = nums1.length;
        int[] ints = new int[pre + nums2.length];
        for (int i = 0; i < pre; i++) {
            ints[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            ints[i+ pre] = nums2[i];
        }
        if (ints.length % 2 == 0) {
            int i = ints.length / 2;
            double i1 = (double)quickFindSortK(ints, i - 1, 0, ints.length - 1);
            double i2 = (double)quickFindSortK(ints, i, 0, ints.length - 1);
            return (i1+i2)/2.0;
        } else {
            int i = quickFindSortK(ints, ints.length / 2, 0, ints.length - 1);
            return i;
        }


    }

    private int quickFindSortK(int[] nums, int k, int l, int r) {
        int index = divideMiddleIndex(nums, l, r);
        int rank = index - l;
        if (k == rank) {
            return nums[index];
        } else if(k>rank) {
            return quickFindSortK(nums, k-rank-1, index+1, r);
        } else {
            return quickFindSortK(nums, k, l, index-1);
        }
    }

    private int divideMiddleIndex(int[] nums, int le, int ri) {
        int lo = le;
        int hi = ri;
        int base = nums[le];
        while(lo<=hi) {
            while (lo<=hi&&base>=nums[lo]) {
                lo++;
            }
            while (lo<=hi&&base<nums[hi]) {
                hi--;
            }
            //交换
            if (lo<=hi) {
                int tmp=nums[hi];
                nums[hi]=nums[lo];
                nums[lo]=tmp;
            } else {
                int tmp=nums[le];
                nums[le]=nums[hi];
                nums[hi]=tmp;
            }
        }
        return hi;
    }

    private int[] divideMiddle(int[] nums, int le, int ri) {
        //交换函数，太丑了；
        //三向切分怎么写？
        int lo = le;
        int hi = ri;
        int base = nums[le];
        while(lo<=hi) {
            while (lo<=hi&&base>=nums[lo]) {
                lo++;
            }
            while (lo<=hi&&base<nums[hi]) {
                hi--;
            }
            //交换
            if (lo<=hi) {
                int tmp=nums[hi];
                nums[hi]=nums[lo];
                nums[lo]=tmp;
            } else {
                int tmp=nums[le];
                nums[le]=nums[hi];
                nums[hi]=tmp;
            }
        }
        return nums;
    }
}
