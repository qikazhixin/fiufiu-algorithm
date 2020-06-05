package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

//Sort 5
public class NumAndString3 {

    @Test
    public void test() {
        Assert.assertEquals("pip", longestPalindrome("spipt"));
    }

    //容易的解法是动态规划，
    //思路：回文串的两侧同时减去，依然是回文串；
    //状态方程：P(i,j)=P(i+1,j-1)&&(Si==Sj)
    //初始状态：数量为1即true，数量为2，则判断两个是否相等

    public String longestPalindrome(String s) {

        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i)).append("#");
        }
        String sp = builder.toString();
        int maxIndex=0;
        int rmax = 0;
        int pos = 0;
        int i = 1;
        //j = 2*pos - i;
        //边界问题
        int len = sp.length();
        int[] rl = new int[len];
        //rl[x]以x为基准，能到达两侧的距离；
        //s默认是已经添加了#的字符串
        rl[0] = 1;
        while(i< len) {
            int j = 2*pos - i;
            if (i>rmax || 2*pos-rmax>=j-(rl[j]-1)) {
                int t = Math.max(i, rmax);
                while(t< len && 2*i-t>=0 && sp.charAt(t) == sp.charAt(2*i-t)) {
                    t++;
                }
                rl[i] = t-i;
                rmax=t-1;
                pos=i;
            } else {
                rl[i] = rl[j];
            }
            maxIndex = rl[i]>rl[maxIndex]?i:maxIndex;
            i++;
        }
        return sp.substring(maxIndex - (rl[maxIndex] - 1), maxIndex + (rl[maxIndex] - 1)).replace("#", "");

    }
}
