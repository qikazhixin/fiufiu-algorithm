package org.fiufiu.leetcode;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence sequence = new FindContinuousSequence();
        sequence.findContinuousSequence(9);
    }

    public int[][] findContinuousSequence(int target) {

//        new
        List<int[]> ls = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int sum=0;
        for (int i=1;i<target;i++) {
            sum = sum+i;
            queue.add(i);
            if (sum==target) {

            } else if (sum<target) {
                continue;
            } else if (sum>target) {
                while(sum>target) {
                    Integer poll = queue.poll();
                    sum=sum-poll;
                }
                if (sum<target) {
                    continue;
                }
            }
            int[] ints = new int[queue.size()];
            Iterator<Integer> iterator = queue.iterator();
            int j=0;
            while(iterator.hasNext()) {
                ints[j++]=iterator.next();
            }
            ls.add(ints);

        }
        int[][] ints = new int[ls.size()][];
        Iterator<int[]> iterator = ls.iterator();
        int j=0;
        while(iterator.hasNext()) {
            ints[j++]=iterator.next();
        }
        return ints;
    }
}
