package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> list = combine.combine(4, 2);
        System.out.println(list);
    }

    /*public List<List<Integer>> combine(int n, int k) {

        combine(new Stack<>(), 1, n, k);
        return ls;

    }

    private List<List<Integer>> ls = new ArrayList<>();

    private void combine(Stack<Integer> list, int start, int end, int num) {
        if (num==0) {
            ls.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;end+1-i>=num;i++) {
            list.add(i);
            combine(list, i+1, end, num-1);
            list.pop();
        }
    }*/

    //LeetCode
    public List<List<Integer>> combine(int n, int k) {
    // init first combination
    LinkedList<Integer> nums = new LinkedList<Integer>();
    for(int i = 1; i < k + 1; ++i)
      nums.add(i);
    nums.add(n + 1);

    List<List<Integer>> output = new ArrayList<List<Integer>>();
    int j = 0;
    while (j < k) {
      // add current combination
      output.add(new LinkedList(nums.subList(0, k)));
      // increase first nums[j] by one
      // if nums[j] + 1 != nums[j + 1]
      j = 0;
      while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
        nums.set(j, j++ + 1);
      nums.set(j, nums.get(j) + 1);
    }
    return output;
  }


}
