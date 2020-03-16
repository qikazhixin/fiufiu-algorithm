package org.fiufiu.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class GcdOfStrings {

    public static void main(String[] args) {
        GcdOfStrings gcd = new GcdOfStrings();
        System.out.println(gcd.gcdOfStrings("ABAB", "ABABAB"));
    }

    public String gcdOfStrings(String str1, String str2) {

        String sh=str1.length()>=str2.length()?str2:str1;
        String lo=str1.length()>=str2.length()?str1:str2;
        int len=sh.length();
        int[] ints = new int[len+1];
        LinkedList<Integer> ls = new LinkedList<>();
        for (int i=1;i<ints.length;i++) {
            if (len%i==0) {
                ls.addFirst(i);
            }
        }
        //解析
        Iterator<Integer> iterator = ls.iterator();
        while (iterator.hasNext()) {
            Integer range = iterator.next();
            if (findStr(sh, range, sh)&&findStr(lo, range, sh)){
                return sh.substring(0, range);
            }
        }
        return "";
    }

    private boolean findStr(String str, int range, String target) {
        if (str.length()==range) {
            if (target.equals(str)) {
                return true;
            }
            return false;
        }
        if (str.length()%range!=0) {
            return false;
        }
        int i = str.length() / range;
        for (int j=1;j<i;j++) {
            for (int k=0;k<range;k++) {
                if (str.charAt(k)==str.charAt(k+range*j)) {
                } else {
                    return false;
                }

            }
        }
        return true;

    }
}
