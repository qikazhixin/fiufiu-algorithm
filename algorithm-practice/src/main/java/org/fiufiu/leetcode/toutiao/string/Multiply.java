package org.fiufiu.leetcode.toutiao.string;

import org.junit.Assert;
import org.junit.Test;

public class Multiply {

    @Test
    public void test() {
//        Assert.assertEquals(multiply("2", "3"), "6");
//        Assert.assertEquals(multiply("123", "456"), "56088");
//        Assert.assertEquals(multiply("99999", "99999"), "9999800001");
        Assert.assertEquals(multiply("0", "99999"), "0");
    }

    public String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1<=0||len2<=0) {
            return "0";
        }
        int[] tmp = new int[len1+len2];
        for(int i = 0; i < len1; i++) {
            int indexI = len1 - 1 - i;
            for (int j = 0; j< len2;j++) {
                tmp[indexI + len2 - 1 - j]=tmp[indexI + len2 - 1 - j]+
                        (num1.charAt(i)-48)*(num2.charAt(j)-48);
            }
        }
        for (int i=0;i<tmp.length;i++) {
            int rig = tmp[i];
            int i1 = rig / 100;
            if(i1 > 0) {
                tmp[i+2]+=i1;
                rig=rig%100;
            }
            int i2 = rig / 10;
            if(i2 > 0) {

                tmp[i+1]+=i2;
                rig=rig%10;
            }
            tmp[i]=rig;
        }
        StringBuilder builder = new StringBuilder();
        boolean b=false;
        for (int i=tmp.length-1;i>=0;i--) {
            if (tmp[i]==0&&!b) {
                continue;
            } else if(tmp[i]!=0&&!b) {
                b=true;
            }
            builder.append(tmp[i]);
        }

        return builder.toString().isEmpty()?"0":builder.toString();
    }
}
