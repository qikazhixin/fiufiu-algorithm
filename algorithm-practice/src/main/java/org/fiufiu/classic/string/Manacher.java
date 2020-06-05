package org.fiufiu.classic.string;

import org.junit.Test;

import java.util.Arrays;

public class Manacher {

    //解决：回文串的问题
    //思路：回文对称性
    //先将字符串扩展到奇数；
    //然后动态计算 rl[]，这个数组的作用是：记录以索引为基础的的最大回文子串；
    //如何计算这个【回文半径数组】，回文是对称的，通过已经算过的元素来计算；
    //rmax，pos，i，j

    @Test
    public void testRLArray() {
        System.out.println(Arrays.toString(creatRlArrays(pre("aba"))));
        System.out.println(Arrays.toString(creatRlArrays(pre("abba"))));
    }

    public int longestPalindrome(String s) {
        int[] ints = creatRlArrays(pre(s));
        return 0;
    }

    private String pre(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i)).append("#");
        }
        return builder.toString();
    }

    //这是我的版本
    //在遍历的时候动态记录最大值；
    private int[] creatRlArrays(String s) {
        //对于一个区域而言，都有一个最长回文的右边界rmax，以及产生回文的中点pos；
        //对于某个i，如果在rmax以内，表示这个回文其实是知道一部分信息的，因为回文是对称的，
        //利用i相对于pos的对称点j，如果j的最长回文在pos的左界内，则rl[i]=rl[j]；否则要从边界处继续对比；
        //如果i在rmax外，则需要以i为中心进行暴力法；
        int rmax = 0;
        int pos = 0;
        int i = 1;
        //j = 2*pos - i;
        //边界问题
        int len = s.length();
        int[] rl = new int[len];
        //rl[x]以x为基准，能到达两侧的距离；
        //s默认是已经添加了#的字符串
        rl[0] = 1;
        while(i< len) {
            int j = 2*pos - i;
            if (i>rmax || 2*pos-rmax>=j-(rl[j]-1)) {
                int t = Math.max(i, rmax);
                while(t< len && 2*i-t>=0 && s.charAt(t) == s.charAt(2*i-t)) {
                    t++;
                }
                rl[i] = t-i;
                rmax=t-1;
                pos=i;
            } else {
                rl[i] = rl[j];
            }
            i++;
        }
        return rl;
    }

}
