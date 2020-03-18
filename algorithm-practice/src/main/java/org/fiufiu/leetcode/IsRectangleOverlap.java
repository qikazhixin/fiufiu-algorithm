package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class IsRectangleOverlap {

    @Test
    public void test() {
//        Assert.assertTrue(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
//        Assert.assertFalse(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
//        Assert.assertTrue(isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
        Assert.assertFalse(isRectangleOverlap(new int[]{206110757,199595273,851054072,983256382},
                new int[]{-898677230,-47320317,-858614307,736177810}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    //||rec2[3]<=rec1[3]||rec2[2]<=rec1[2]||rec2[0]>=rec1[0]
        /*if (rec2[0]>=rec1[2]||rec2[1]>=rec1[3]) {
            return false;
        } else if (rec2[0]>rec1[0]) {
            if (rec2[3]<=rec1[1]) {
                return false;
            }
            return true;
        } else {

        }*/
        if (rec2[0]>=rec1[2]||rec2[1]>=rec1[3]||rec2[2]<=rec1[0]||rec2[3]<=rec1[1]) {
            return false;
        }

        return true;
    }
}
