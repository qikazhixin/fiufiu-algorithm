package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class NumTrees {

    @Test
    public void test() {
//        Assert.assertEquals(0, numTrees(0));
//        Assert.assertEquals(1, numTrees(1));
//        Assert.assertEquals(2, numTrees(2));
        Assert.assertEquals(5, numTrees(3));
    }

    public int numTrees(int n) {
        if (n==0) {
            return 0;
        }
        int[] count = new int[n + 1];
        count[0]=1;
        count[1]=1;
        for (int i=2;i<n+1;i++) {
            int counts=0;
            for (int j=1;j<=i;j++) {
                int left=j-1;
                int right=i-j;

                counts=counts+count[left]*count[right];
            }
            count[i]=counts;
        }
        return count[n];

    }
}
