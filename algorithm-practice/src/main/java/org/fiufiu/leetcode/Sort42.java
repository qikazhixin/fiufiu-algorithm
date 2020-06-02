package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort42 {

    @Test
    public void test() {
        Assert.assertEquals(6, trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        int len = height.length;
        if (len ==0) {
            return 0;
        }
        int max = findLargestIndex(height, 0, len - 1);
        Queue<Integer> right=new LinkedList<>();
        Vector<Integer> tets=new Vector<>();
        LinkedList<Integer> left=new LinkedList<>();
        int tmp=max;
        while(tmp!=-1) {
            right.add(tmp);
            tmp = findLargestIndex(height, tmp + 1, len - 1);
        }
        tmp=max;
        while(tmp!=-1) {
            left.addFirst(tmp);
            tmp = findLargestIndex(height, 0, tmp-1);
        }
        return trap(height, right) + trap(height, left);

    }

    private int findLargestIndex(int[] height, int lo, int hi){
        if (lo>hi){
            return -1;
        }
        int tmp=lo;
        for (int i = lo+1; i <= hi; i++) {
            if (height[tmp]<height[i]){
                tmp=i;
            }
        }
        return tmp;
    }

    private int trap(int[] height, Queue<Integer> q) {
        if (q.size()<=1) {
            return 0;
        }
        int pre=q.poll();
        int next=pre;
        int count=0;
        Iterator<Integer> iterator = q.iterator();
        while (iterator.hasNext()) {
            next=iterator.next();
            int i1 = Math.min(height[next], height[pre]) * (next - pre - 1);
            for (int i = pre+1; i < next; i++) {
                i1-=height[i];
            }
            count+=i1;
            pre=next;
        }
        return count;
    }
}
