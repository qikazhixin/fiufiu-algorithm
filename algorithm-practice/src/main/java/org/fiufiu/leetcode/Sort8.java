package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sort8 {

    @Test
    public void myAtoi() {
        Assert.assertEquals(42, myAtoi("42"));
        Assert.assertEquals(0, myAtoi("+0"));
        Assert.assertEquals(-42, myAtoi("  -42"));
        Assert.assertEquals(4193, myAtoi("4193 with words"));
        Assert.assertEquals(0, myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));

    }


    public int myAtoi(String str) {
        /*Pattern compile = Pattern.compile("^[+-]?[0-9]*");
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            if (group.isEmpty()) {
                return 0;
            }
            char c = group.charAt(0);
            if (c == '-') {
                Pattern compile1 = Pattern.compile("[1-9][0-9]*");
                Matcher matcher1 = compile1.matcher(group);
                if (matcher.find()){
                    String s = matcher.group();


                }
            }

        }
        return 0;*/
        if (str.length()==0) {
            return 0;
        }
        int i=0;
        char c = str.charAt(i);
        while (c==' ') {
            ++i;
            if (i>=str.length()) {
                break;
            }
            c=str.charAt(i);
        }
        int start=i;
        int end=start;
        if (c == '-' || c=='+' || c>='0'&&c<='9') {

            while(true) {
                ++end;
                if (end>=str.length()) {
                    break;
                }
                char c1 = str.charAt(end);
                if (c1 <'0'||c1 >'9') {
                    break;
                }
            }
            String s = str.substring(start, end);

            if ("+".equals(s)||"-".equals(s)) {
                return 0;
            }
            if (s.length()>=13) {
                if (c=='-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            long num = Long.valueOf(s);
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) num;
            }
        } else {
            return 0;
        }

    }
}
