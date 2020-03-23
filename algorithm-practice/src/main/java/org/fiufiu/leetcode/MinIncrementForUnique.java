package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MinIncrementForUnique {

    @Test
    public void test(){
//        Assert.assertEquals(1, minIncrementForUnique(new int[]{1,2,2}));
        Assert.assertEquals(6, minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    public int minIncrementForUnique(int[] A) {
        if(A.length==0) {
            return 0;
        }
        Arrays.sort(A);
        int count=0;
        int repeat=0;
        int pre = A[0];
        for (int i = 1; i < A.length;i++) {
            if (A[i]==pre) {
                repeat++;
                count-=A[i];
            } else {
                int i1 = A[i] -1- pre;
                int min = Math.min(i1, repeat);
                while(min>0) {
                    min--;
                    repeat--;
                    count+=++pre;
                }
                pre=A[i];
            }
        }
        pre=A[A.length-1];
        while(repeat>0) {
            repeat--;
            count+=++pre;
        }
        return count;
        /*if(A.length==0) {
            return 0;
        }
        Arrays.sort(A);
        int count=0;
        int pre = A[0];
        for (int i = 1; i < A.length; ) {
            if (A[i]==pre) {
                int j=i;
                while(j<A.length&&A[j]==pre) {
                    count++;
                    A[j++]++;
                }
            } else {
                pre=A[i++];
            }
        }
        return count;*/
    }
}
