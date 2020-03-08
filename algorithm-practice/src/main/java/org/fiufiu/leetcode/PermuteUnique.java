package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique permute = new PermuteUnique();

        int[] nums={1,1,3,3};
        System.out.println(permute.permute(nums));
    }

    int[] numss;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        numss=nums;
        count=new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }
        permute(list, 0);
        return lists;
    }

    private boolean[] count;

    private List<List<Integer>> lists = new ArrayList<>();

    private void permute(List<Integer> list, int first) {

        if (first == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i=first;i<list.size();i++) {
            if (isRepeat(list, first, i)) {
                continue;
            }
            Collections.swap(list, first, i);
            permute(list, first+1);
            Collections.swap(list, first, i);

        }

    }

    private boolean isRepeat(List<Integer> nums, int first, int n){
        int temp = nums.get(n);
        for (int i=first; i<n; i++){
            if (nums.get(i) == temp){
                return true;
            }
        }
        return false;
    }



}
