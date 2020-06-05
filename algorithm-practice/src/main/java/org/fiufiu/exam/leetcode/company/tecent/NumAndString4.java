package org.fiufiu.exam.leetcode.company.tecent;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumAndString4 {

    @Test
    public void test() {
//        Assert.assertEquals(42, myAtoi("42"));
//        Assert.assertEquals(-42, myAtoi("     -42"));
//        Assert.assertEquals(4193, myAtoi("4193 with words"));
//        Assert.assertEquals(0, myAtoi("words and 987"));
//        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        //首先是获得数字
        //想法是正则或是自己写

        //其次转换成数字；
        // 先判断越界；想法是：将Integer.MAX_VALUE和min转成字符串，自定义比较；越界直接返回

        //转换，使用系统自定义的Integer;但是这里最好自己写；
        //因为没有越界，所以直接用乘法，先将负号移出，乘上每一位；由于2^31-1和-2^31已经直接返回了，所以不存在正数比负数小一的尴尬局面

        //先用正则小试牛刀，顺便看看自己正则用的咋样；
//        String reg = "^\\s*[\\-]?[1-9]?[0-9]*";
        String reg = "^[\\-]?[1-9]+[0-9]*";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str.trim());
        String num = null;
        if (matcher.find()) {
            num = matcher.group();
        }
        if (num==null) {
            return 0;
        }
        //如果越界
        int c = 0;
        Integer res = null;
        if (num.charAt(0) == '-') {
            String s = String.valueOf(Integer.MIN_VALUE);
            if (s.length() == num.length()) {
                c = num.compareTo(s);
                res = c>=0?Integer.MIN_VALUE:null;
            } else if (s.length() > num.length()) {
                res = null;
            } else {
                res = Integer.MIN_VALUE;
            }
        } else {
            String s = String.valueOf(Integer.MAX_VALUE);
            if (s.length() == num.length()) {
                c = num.compareTo(s);
                res = c>=0?Integer.MAX_VALUE:null;
            } else if (s.length() > num.length()) {
                res = null;
            } else {
                res = Integer.MAX_VALUE;
            }
        }
        if (res != null) {
            return res;
        }
        //叠加法
        res=0;
        for (int i = 0,j=1; i < num.length(); i++,j*=10) {
            char c1 = num.charAt(num.length() - 1 - i);
            if (c1 == '-') {
                res=-res;
                break;
            }
            res += (c1-'0') *j;
        }

        return res;
    }
}
