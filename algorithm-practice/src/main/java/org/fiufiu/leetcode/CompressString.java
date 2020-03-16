package org.fiufiu.leetcode;


import org.junit.Assert;
import org.junit.Test;

public class CompressString {

    @Test
    public void test() {

        Assert.assertEquals(compressString("aabcccccaaa"), "a2b1c5a3");
        Assert.assertEquals(compressString("abbccd"), "abbccd");

    }

    public String compressString(String S) {
        if(S.isEmpty()) {
            return S;
        }
        StringBuilder builder = new StringBuilder();
        int i=1;
        char c=S.charAt(0);
        int count=1;
        while(i<S.length()){
            if (S.charAt(i)==c) {
                count++;
            } else {
                builder.append(c).append(count);
                c=S.charAt(i);
                count=1;
            }
            i++;
        }
        builder.append(c).append(count);
        return builder.toString().length()<S.length()?builder.toString():S;
    }
}
