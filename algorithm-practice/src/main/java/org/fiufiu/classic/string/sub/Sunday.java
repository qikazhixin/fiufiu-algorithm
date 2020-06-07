package org.fiufiu.classic.string.sub;

import org.junit.Test;

public class Sunday implements StringMatcher {

    //思路
    //与BM算法不同的是，从前往后；
    //而且关注的是source中的下一位在pattern中的位置

    @Test
    public void test() {
//        System.out.println(indexOf("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        System.out.println(indexOf("THIS IS A BIG TIGER", "IG"));

    }

    private int[] getRight(String pat) {
        int[] right = new int[256];
        for (int i = 0; i < 256; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < pat.length(); i++) {
            right[pat.charAt(i)] = i;
        }
        return right;
    }

    @Override
    public int indexOf(String source, String pattern) {
        int[] right = getRight(pattern);
        int i=0;
        while(i<source.length()) {
            int j;
            for (j = 0; j < pattern.length(); ) {
                if (pattern.charAt(j) == source.charAt(i+j)) {
                    j++;
                } else {
                    i+=pattern.length()-1-right[source.charAt(i+j+1)];
                    j=0;
                    break;
                }
            }
            if (j==pattern.length()) {
                return i;
            }
        }

        return -1;
    }
}
