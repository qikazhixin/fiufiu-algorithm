package org.fiufiu.leetcode.toutiao.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class GetPermutation {

    @Test
    public void test(){
        Assert.assertEquals("213",getPermutation(3,3));
        Assert.assertEquals("2314",getPermutation(4,9));
        Assert.assertEquals("1",getPermutation(1,1));
        Assert.assertEquals("12",getPermutation(2,1));
    }

    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        List<Integer> ls = new ArrayList<>();
        int[] ans = new int[n];
        ans[n-1]=1;
        for (int i = n-1; i > 0; i--) {
            ans[i-1]=ans[i]*(n+1-i);
            ls.add(n-i);
        }
        ls.add(n);
        k=k-1;
        for (int i = 1; i < n; i++) {
            if(ans[i]==1) {
                builder.append(ls.remove(k));
            } else {
                int i1 = k / ans[i];
                Integer remove = ls.remove(i1);
                builder.append(remove);
                k=k%ans[i];
            }
        }

        builder.append(ls.remove(0));
        return builder.toString();

    }
}
