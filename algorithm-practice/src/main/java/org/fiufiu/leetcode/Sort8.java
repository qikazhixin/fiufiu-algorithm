package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sort8 {

    @Test
    public void myAtoi() {
//        Assert.assertEquals(42, myAtoi("42"));
//        Assert.assertEquals(0, myAtoi("+0"));
        Assert.assertEquals(-42, myAtoi("  -42"));
        Assert.assertEquals(4193, myAtoi("4193 with words"));
        Assert.assertEquals(0, myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));

    }

    @Test
    public void test2() {
        Pattern compile = Pattern.compile("^[+-]?[0]{0,}[0-9]*");
//        String s="4193 with words";
        String s="   00004193 with words";
        s=s.trim();
        Matcher matcher = compile.matcher(s);
        if (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }

    }

    public int myAtoi(String str) {
        /*Pattern compile = Pattern.compile("^[+-]?[0-9]*");

        str=str.trim();
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            if (group.isEmpty()) {
                return 0;
            }
            char c = group.charAt(0);
            Pattern compile1 = Pattern.compile("[1-9][0-9]*");
            Matcher matcher1 = compile1.matcher(group);
            if (matcher1.find()){
                String s = matcher1.group();
                if (c == '-') {
                    s=c+s;
                }
                if (s.length()>13) {
                    if (c=='-') {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    long aLong = Long.valueOf(s);
                    if (aLong > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if(aLong < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    } else {
                        return (int) aLong;
                    }
                }

            }


        }
        return 0;*/
        str=str.trim();
        if (str.length()==0) {
            return 0;
        }
        int i=0;
        char c = str.charAt(i);
        if (c == '-'||c=='+') {
            str=str.substring(1);
        }
        if (str.length()==0) {
            return 0;
        }
        int end=i;
        boolean b=true;
        while(end<str.length()) {
            char c1 = str.charAt(end);
            if (c1<'0'||c1>'9') {
                break;
            } else if (b) {
                if (c1=='0') {
                    i++;
                } else {
                    b=false;
                }
                end++;
            } else if (!b) {
                end++;
            }
        }
        String s = str.substring(i, end);
        if(s.length()==0){
            return 0;
        }
        if (s.length()>=13) {
            if (c=='-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        long num = c=='-' ?Long.valueOf(c+s):Long.valueOf(s);
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) num;
        }

    }
}
