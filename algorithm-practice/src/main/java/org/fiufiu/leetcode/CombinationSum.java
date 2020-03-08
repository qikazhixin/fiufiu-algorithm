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
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new Stack<>());
        return res;
    }

    public static List<List<Integer>> res =  new ArrayList<>();

    private static void backtrack(int[] candidates, int start, int target, Stack<Integer> track) {
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            track.push(candidates[i]);
            backtrack(candidates, i, target-candidates[i], track);
            track.pop();
        }
    }

}
