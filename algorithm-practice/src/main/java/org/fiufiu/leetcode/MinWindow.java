package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MinWindow {

    public static void main(String[] args) {
        MinWindow window = new MinWindow();
//        System.out.println(window.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(window.minWindow("aa", "a"));
    }

    public String minWindow(String s, String t) {
        int[] init = new int[256];
        for (int i=0;i<256;i++) {
            init[i]=-2;
        }
        for (int i=0;i<t.length();i++) {
            init[t.charAt(i)] = -1;
        }
        for (int i=0;i<s.length();i++) {
            if (init[s.charAt(i)] == -2) {
                continue;
            }
            init[s.charAt(i)] = i;
        }
        int start=s.length();
        int end=-1;
        for (int i=0;i<t.length();i++) {
            int i1 = init[t.charAt(i)];
            if (i1 ==-1) {
                return "";
            }
            start = start <= i1 ? start : i1;
            end = end >= i1 ? end : i1;
        }
        return s.substring(start, end+1);

    }
}
