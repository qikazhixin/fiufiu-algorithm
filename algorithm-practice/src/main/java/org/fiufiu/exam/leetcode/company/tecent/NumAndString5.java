package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class NumAndString5 {

    @Test
    public void test() {
//        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));
//        Assert.assertEquals("", longestCommonPrefix(new String[]{}));
//        Assert.assertEquals("", longestCommonPrefix(new String[]{""}));
//        Assert.assertEquals("a", longestCommonPrefix(new String[]{"a"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"babb", "caa"}));
//        System.out.println("a".substring(0));
//        System.out.println("a".substring(0, 1));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }



    /*//运用二叉搜索的方式来试试；
    public String longestCommonPrefix(String[] strs) {
        int min=Integer.MAX_VALUE;
        if(strs.length == 0) {
            return "";
        }
        for (String s:strs) {
            min=min<s.length()?min:s.length();
        }
        if (min == 0) {
            return "";
        }
        int i = binaryS(strs, min-1, 0, min-1, -1);

        return strs[0].substring(0, i+1);

    }

    //为什么会错，因为我只是判断i位置的元素，但是这个二分思路是错的；
    private int binaryS(String[] strs, int min, int left, int right, int max) {
        if (left<0||right>min||left>right) {
            return max;
        }
        int j=(left+right)/2;
        char c = strs[0].charAt(j);
        boolean b = true;
        for (int i = 1; i < strs.length; i++) {
            if (c != strs[i].charAt(j)) {
                b=false;
                break;
            }
        }
        if (b) {
            return binaryS(strs, min, j+1, right, j);
        } else {
            return binaryS(strs, min, left, j-1, max);
        }

    }*/
}
