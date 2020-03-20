package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GetLeastNumbers {

    @Test
    public void test() {
//        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3, 2, 1, 4, 6}, 2)));
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8)));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        queue.add(4);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        System.out.println(queue.peek());
    }

    //add 快排的思想
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        queue.add(arr[0]);


        for (int i = 1; i < arr.length; i++) {
            if (queue.size()<k) {
                queue.add(arr[i]);
            } else {
                //找到位置移除最大
                if (arr[i]>=queue.peek()) {
                } else {
                    queue.add(arr[i]);
                    Integer poll = queue.poll();

                    System.out.println(poll);
                }
            }
        }
        int [] res = new int[queue.size()];
        Iterator<Integer> iterator = queue.iterator();
        int i=0;
        while(iterator.hasNext()) {
            res[i]=iterator.next();
            i++;
        }
        return res;

    }

}
