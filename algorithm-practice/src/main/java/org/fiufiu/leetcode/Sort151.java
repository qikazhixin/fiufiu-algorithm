package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Sort151 {

    @Test
    public void test() {
//        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
        Assert.assertEquals("world! hello", reverseWords("  hello world!  "));
        Assert.assertEquals("example good a", reverseWords("a good   example"));
        Assert.assertEquals("", reverseWords("  "));

    }

    public String reverseWords(String s) {
        s=s.trim();
        String[] split = s.split(" +");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i > 0; i--) {
            builder.append(split[i]).append(' ');
        }
        String res = "";
        if (split.length > 0) {
            res = builder.append(split[0]).toString();
        }
        return res;
    }
}
