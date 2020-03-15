package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS test = new LengthOfLIS();
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(test.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length<=0) {
            return 0;
        }
        int maxans=1;
        int[] dp=new int[nums.length];
        dp[0]=1;
        for (int i=1;i<dp.length;i++) {
            int maxval=0;
            for (int j=0;j<i;j++) {
                if (nums[i]>nums[j]) {
                    maxval=Math.max(maxval, dp[j]);
                }
            }
            dp[i]=maxval+1;
            maxans=Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    /*public int lengthOfLIS(int[] nums) {
        LinkedList<Integer> list= new LinkedList<>();
        LinkedList<Integer> tmp= new LinkedList<>();
        //每次找一个递增数列，与前一数列合并

        int last=nums[0];
        list.add(last);
        for (int i=1;i<nums.length;i++) {
            //是递增数列
            System.out.println("before merge" + list);
            System.out.println("before merge tmp" + tmp);
            if (nums[i]>nums[i-1]) {
                if (tmp.isEmpty()) {
                    tmp.add(nums[i-1]);
                }
                tmp.add(nums[i]);
            } else {
                //把两个数列合并
                if (tmp.isEmpty()) {
                    merge(list, nums[i]);
                } else {
                    merge(list, tmp);
                }

            }

        }
        if (!tmp.isEmpty()) {
            merge(list, tmp);
        }
        System.out.println("last"+list);
        return list.size();

    }

    private void merge(LinkedList<Integer> list, int tmp) {
        if (tmp>list.getLast()) {
            list.add(tmp);
            return;
        } else if(tmp==list.getLast()) {

        } else {
            if (list.size()==1) {
                list.removeLast();
                list.add(tmp);
            } else {
                if (list.get(list.size()-2)>tmp) {
                    list.removeLast();
                    list.add(tmp);
                }
            }
        }

    }

    private void merge(LinkedList<Integer> list, LinkedList<Integer> tmp) {
        //先找到第一个元素的位置
        System.out.println(tmp);
        System.out.println("list"+list);
        Integer first = tmp.getFirst();
        int last=0;
        for (int i=0;i<list.size();i++) {
            if (list.get(i)<first) {

            } else {
                last=list.size()-i;
                break;
            }
        }
        if (tmp.size()>last) {

            //凭借
            int size = list.size();
            if (last==size) {
                list.clear();
                list.addAll(tmp);
            } else {
                for(int j=0;j<last;j++) {
                    list.removeLast();
                }
                Iterator<Integer> iterator = tmp.iterator();
                while(iterator.hasNext()) {
                    list.add(iterator.next());
                }

                System.out.println("--"+list);

            }

        } else if (tmp.size()==last){
            //比较最后一位
            if (tmp.getLast()<list.getLast()) {
                list.clear();
                list.addAll(tmp);
            }
        } else {
            //无变化
        }

        tmp.clear();

    }*/

}
