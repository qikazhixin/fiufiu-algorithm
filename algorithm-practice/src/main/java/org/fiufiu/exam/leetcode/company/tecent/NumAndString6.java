package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class NumAndString6 {

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //思路，x+y+z=0;
        //对于每个x，则y+z=-x;
        //元素中存在重复，所以要去重
        //去重思路：双map，第一个校验x是否重复，第二个校验y是否重复
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (map1.containsKey(nums[i])) {

            } else {
                int target = -nums[i];
                HashMap<Integer, Integer> map2 = new HashMap<>();
                Set<Integer> set2 = new HashSet<>();

                for (int j = i+1; j < nums.length ; j++) {
                    if (set2.contains(nums[j]) || (map1.containsKey(nums[j])&&map1.get(nums[j]).contains(nums[i]))) {
                        continue;
                    }

                    Integer integer = map2.get(nums[j]);
                    if (integer !=null) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(integer);
                        set2.add(nums[j]);
                        set2.add(integer);
                        res.add(list);
                    } else {
                        map2.put(target - nums[j], nums[j]);
                    }

                }
                map1.put(nums[i], set2);
            }
        }

        return res;
    }
}
