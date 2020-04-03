package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Sort91 {

    @Test
    public void test() {
//        Assert.assertEquals(2, numDecodings("12"));
//        Assert.assertEquals(3, numDecodings("226"));
        Assert.assertEquals(1, numDecodings("27"));
    }

    public int numDecodings(String s) {
        int len = s.length();
        if (len ==0){
            return 0;
        }
        int[] ans = new int[len+1];
        //include 0-9;every char
        ans[0] = 1;
        ans[1] = s.charAt(len - 1)=='0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            char c1 = s.charAt(len - 1 - i);
            char c2 = s.charAt(len - i);
            int one = c1 > '0'&& c1 <='9'?1:0;
            int two = c1 == '1'||(c1=='2'&&c2 >= '0'&& c2 <='6')?1:0;
            ans[i+1]=one*ans[i]+two*ans[i-1];
        }
        return ans[len];
    }
}
