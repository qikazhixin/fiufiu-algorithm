package org.fiufiu.leetcode;

import com.google.common.math.IntMath;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CountPrimes {

    @Test
    public void test() {
        Assert.assertEquals(4,countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean[] ans = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!ans[i]) {
                for (int j = i*2; j < n; j+=i) {
                    ans[j]=true;
                }
            }
        }
        int count=0;
        for (int i = 2; i < n; i++) {
            if (!ans[i]) {
                count++;
            }
        }
        return count;
    }

}
