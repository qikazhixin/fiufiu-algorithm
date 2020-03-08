package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    /*public List<List<Integer>> subsets(int[] nums) {
        lists.add(Collections.emptyList());
        subsets(new Stack<Integer>(), nums, 0);
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    private void subsets(Stack<Integer> ls, int[] nums, int start) {
        if (start >= nums.length) {
            return;
        }
        for (int i=start;i<nums.length;i++) {
            ls.add(nums[i]);
            lists.add(new ArrayList<>(ls));
            subsets(ls, nums, i+1);
            ls.pop();
        }

    }*/


    /*
作者：LeetCode
链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }


}
