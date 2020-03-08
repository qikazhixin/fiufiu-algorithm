package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        CombinationSum2 sum2 = new CombinationSum2();
        List<List<Integer>> lists = sum2.combinationSum2(nums, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates,target,candidates.length-1,new Stack<Integer>());
        return list;
    }

    private List<List<Integer>> list = new ArrayList<>();

    private void backtrace(int[] candidates, int target, int end, Stack<Integer> stack) {
        if(target<0) {
            return;
        }
        if(target==0) {
            list.add(new ArrayList<>(stack));
            return;
        }

        for(int i=end;i>=0;i--) {
            if (i < end&&candidates[i]==candidates[i+1]) {
                continue;
            }
            stack.push(candidates[i]);
            backtrace(candidates, target-candidates[i], i-1, stack);
            stack.pop();
        }

    }
}
