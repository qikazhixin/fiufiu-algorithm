package org.fiufiu.classic.string;

import org.junit.Test;

public class BM implements StringMatcher {

    @Test
    public void test() {
        System.out.println(indexOf("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        System.out.println(indexOf("THIS IS A BIG TIGER", "IG"));

    }


    //思路
    //坏字符匹配
    //倒着匹配；从右到左；不匹配就移动到从右开始的匹配位置；
    //好后缀规则
    //利用已经匹配的子字符;

    //存储最右的索引
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
        //从右到左匹配；
        int[] right = getRight(pattern);
        int i=0;
        final int pLen = pattern.length() - 1;
        int j = pLen;
        i= j;
//        while(i<source.length()) {

            while(j>=0) {
                if (source.charAt(i) == pattern.charAt(j)) {
                    i--;
                    j--;
                } else {
                    i+=pLen-right[source.charAt(i)];
                    j=pLen;
                    if (i>source.length()) {
                        break;
                    }
                }
            }
            if (j<0) {
                return i+1;
            }
            return -1;
//        }

    }

    //算法第四版的实现
//    public static int Search(String txt, String pat, int[] right) {
//        int M = txt.length();
//        int N = pat.length();
//        int skip;
//        for (int i = 0; i < M - N; i += skip) {
//            skip = 0;
//            for (int j = N - 1; j >= 0; j--) {
//                if (pat.charAt(j) != txt.charAt(i + j)) {
//                    skip = j - right[txt.charAt(i + j)];
//                    if (skip < 1)
//                        skip = 1;
//                    break;
//                }
//            }
//            if (skip == 0)
//                return i;
//        }
//        return -1;
//    }
}
