package org.fiufiu.classic.string;

import org.junit.Test;

import java.util.Arrays;

public class KMP implements StringMatcher{

    @Test
    public void testGetNext() {
        System.out.println(Arrays.toString(getNext("ABCDABD".toCharArray())));
    }

    @Test
    public void testIndexOf() {
        System.out.println(indexOf("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }

    //next数组求解
    //next[0] = -1。
    //如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
    //如果p[j] = p[k], 则next[j+1] = next[k] + 1;
    //如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,如果不相等,则继续递归前缀索引,\
    //令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
    private int[] getNext(char[] p) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止

        //我的写法
        int len = p.length;
        int[] next = new int[len];
        int k = -1;
        next[0] = k;
        for (int j = 1; j < len; j++) {
            while(true) {
                if (k == -1||p[j-1]==p[k]) {
                    next[j] = k+1;
                    k++;
                    break;
                } else {
                    k = next[k];
                }
            }
        }
        return next;
        //别人的写法
//        int pLen = p.length;
//        int[] next = new int[pLen];
//        int k = -1;
//        int j = 0;
//        next[0] = -1; // next数组中next[0]为-1
//        while (j < pLen - 1) {
//            if (k == -1 || p[j] == p[k]) {
//                k++;
//                j++;
//                next[j] = k;
//            } else {
//                k = next[k];
//            }
//        }
//        return next;
        //改进，循环中改了
//        if (k == -1 || p[j] == p[k]) {
//            k++;
//            j++;
//            // 修改next数组求法
//            if (p[j] != p[k]) {
//                next[j] = k;// KMPStringMatcher中只有这一行
//            } else {
//                // 不能出现p[j] = p[next[j]],所以如果出现这种情况则继续递归,如 k = next[k],
//                // k = next[[next[k]]
//                next[j] = next[k];
//            }
//        } else {
//            k = next[k];
//        }
    }



    @Override
    public int indexOf(String source, String pattern) {
        //我的写法
        int len = source.length();
        int[] next = getNext(pattern.toCharArray());
        int j = 0;
        for (int i = 0; i < len; ) {
            if (j==-1) {
              i++;
              j=0;
            } else if(j >= pattern.length()) {
                return i-j;
            } else if (source.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            } else {
                j=next[j];
            }
        }
        return -1;
//        别人的写法
//        int i = 0, j = 0;
//        char[] src = source.toCharArray();
//        char[] ptn = pattern.toCharArray();
//        int sLen = src.length;
//        int pLen = ptn.length;
//        int[] next = getNext(ptn);
//        while (i < sLen && j < pLen) {
//            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
//            if (j == -1 || src[i] == ptn[j]) {
//                i++;
//                j++;
//            } else {
//                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
//                j = next[j];
//            }
//        }
//        if (j == pLen)
//            return i - j;
//        return -1;

    }


    //动态规划的思想，dfa确定有限状态机的思路（算法第四版）



}
