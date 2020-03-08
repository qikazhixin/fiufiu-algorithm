package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums={1,2,3};
        System.out.println(permute.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }
        permute(list, nums.length, new LinkedList<>());
        return lists;
    }

    private List<List<Integer>> lists = new ArrayList<>();

    private void permute(List<Integer> last, int count, LinkedList<Integer> list) {
        if (count==1) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(last.get(0));
            lists.add(list1);
            return;
        }
        for (Integer s: last) {
            list.addLast(s);
            ArrayList<Integer> list1 = new ArrayList<>(last);
            list1.remove(s);
            permute(list1, count-1, list);
            list.removeLast();
        }

    }

    //
    class Solution {
        public void backtrack(int n,
                              ArrayList<Integer> nums,
                              List<List<Integer>> output,
                              int first) {
            // if all integers are used up
            if (first == n)
                output.add(new ArrayList<Integer>(nums));
            for (int i = first; i < n; i++) {
                // place i-th integer first
                // in the current permutation
                Collections.swap(nums, first, i);
                // use next integers to complete the permutations
                backtrack(n, nums, output, first + 1);
                // backtrack
                Collections.swap(nums, first, i);
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            // init output list
            List<List<Integer>> output = new LinkedList();

            // convert nums into list since the output is a list of lists
            ArrayList<Integer> nums_lst = new ArrayList<Integer>();
            for (int num : nums)
                nums_lst.add(num);

            int n = nums.length;
            backtrack(n, nums_lst, output, 0);
            return output;
        }
    }

}
