package org.fiufiu.leetcode;


import com.google.common.math.IntMath;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CanMeasureWater {

    @Test
    public void test() {
//        Assert.assertTrue(canMeasureWater(3,5,4));
//        Assert.assertTrue(canMeasureWater(3,4,5));
//        Assert.assertTrue(canMeasureWater(1,2,3));
//        Assert.assertFalse(canMeasureWater(6,2,5));

        IntMath.gcd(8, 6);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z>x+y) {
            return false;
        }
        boolean[] ans = new boolean[x+y+1];
        ans[x]=true;
        ans[y]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            addIntoQueue(x+y, ans, queue, x - poll);
            addIntoQueue(x+y, ans, queue, x + poll);
            addIntoQueue(x+y, ans, queue, y - poll);
            addIntoQueue(x+y, ans, queue, y + poll);
        }
        return ans[z];
    }

    private void addIntoQueue(int max, boolean[] ans, Queue<Integer> queue, int i) {
        if (i>=0&&i<=max&&!ans[i]) {
            ans[i]=true;
            queue.add(i);
        }
    }
}
