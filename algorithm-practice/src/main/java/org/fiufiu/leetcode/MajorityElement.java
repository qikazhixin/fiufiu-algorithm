package org.fiufiu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        if (target<=0) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>(target);
        for (int i=0;i<nums.length;i++) {
            Integer integer = map.get(nums[i]);
            if (integer==null) {
                map.put(nums[i],1);
            } else if(integer>=target) {
                return nums[i];
            } else {
                map.put(nums[i], 1+integer);
            }
        }
        return -1;
    }

    //Boyer-Moore
}
