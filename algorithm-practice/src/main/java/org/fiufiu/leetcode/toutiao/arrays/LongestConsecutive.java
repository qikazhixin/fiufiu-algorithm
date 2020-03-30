package org.fiufiu.leetcode.toutiao.arrays;

import com.google.common.math.IntMath;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LongestConsecutive {

    @Test
    public void test(){
        Assert.assertEquals(4, longestConsecutive(new int[]{200,2,100,1,3,4}));
        Assert.assertEquals(4, longestConsecutive(new int[]{1,2,2,1,3,4}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }


        
        Integer[] ans = new Integer[set.size()];
        set.toArray(ans);
        Arrays.sort(ans);
        int max=0;
        int pre=0;
        for (int i = 1; i < ans.length; i++) {
            if (ans[i]!=ans[i-1]+1){
                max=Math.max(max, i-pre);
                pre=i;
            }
        }
        max=Math.max(max, ans.length-pre);
        return max;
    }
}
