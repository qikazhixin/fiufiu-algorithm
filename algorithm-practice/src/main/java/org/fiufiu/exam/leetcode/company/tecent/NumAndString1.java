package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Sort1
public class NumAndString1 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0,1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{2,3}, twoSum(new int[]{2, 4, 5, 7, 9}, 12));
        Assert.assertArrayEquals(new int[]{2,3}, twoSum(new int[]{2, 4, 5, 7, 9, 13}, 12));
        Assert.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{3, 2, 4}, 6));

    }

    @Test
    public void test2() {
        //0,1
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
        //2,3
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 4, 5, 7, 9}, 12)));
        //2,3
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 4, 5, 7, 9, 13}, 12)));
        //1,2
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }



    //问题，数组的引用变了；引用排序（）//时间复杂度o（lgn）级别
    //有更好的（使用Map）；
    public int[] twoSum(int[] nums, int target) {
        //index数组
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        //关于排序更简洁
        //int[] sortedIndices = IntStream.range(0, nums.length)
        //       .boxed().sorted((i, j) -> nums[i]-nums[j] )
        //        .mapToInt(ele -> ele).toArray();

        //排序
        Arrays.sort(index, (o1, o2) -> {
            if (nums[o1] > nums[o2]) {
                return 1;
            } else if (nums[o1] < nums[o2]) {
                return -1;
            } else {
                return 0;
            }
        });
        //双指针逼近法
        int lo = 0;
        int hi = nums.length - 1;
        while (hi < nums.length && hi > lo) {
            int sum = nums[index[lo]] + nums[index[hi]];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                int[] res = new int[2];
                res[0] = index[lo];
                res[1] = index[hi];
                return res;
            }
        }

        return null;

    }

    public int[] twoSum2(int[] nums, int target) {
        //index数组
        //先判断nums[i]的值是否存在，存在则读取value
        //不存在将target - nums[i]的key值放进去，value是i；
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] res = new int[] {i, map.get(nums[i])};
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return null;

    }
}
