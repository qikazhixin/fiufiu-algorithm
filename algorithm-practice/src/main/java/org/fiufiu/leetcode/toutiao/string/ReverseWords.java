package org.fiufiu.leetcode.toutiao.string;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWords {

    @Test
    public void test() {
//        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
//        Assert.assertEquals("world! hello", reverseWords("  hello world!  "));
//        Assert.assertEquals("example good a", reverseWords("a good   example"));
        Assert.assertEquals("", reverseWords("         "));
    }

    public String reverseWords(String s) {
        //缩减
        boolean b =false;
        if (s.length()<=0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if (' ' == s.charAt(i) && !b) {
                continue;
            } else if (' ' == s.charAt(i) && b) {
                builder.append(' ');
                b =false;
            } else {
                b = true;
                builder.append(s.charAt(i));
            }
        }
        if (builder.length()<=0) {
            return "";
        }
        if (!b) {
            builder.deleteCharAt(builder.length()-1);
        }
        String s1 = builder.toString();
        String[] split = s1.split(" ");
        StringBuilder builder1 = new StringBuilder();
        for (int i=split.length-1;i>=0;i--) {
            builder1.append(split[i]).append(" ");
        }
        return builder1.deleteCharAt(builder1.length()-1).toString();

    }
}
