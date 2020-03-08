package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Multiply {

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("2455555", "3256"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();

        int[] res = new int[len1 + len2];
        int[] nums1=new int[len1];
        int[] nums2=new int[len2];
        for (int i=0;i<len1;i++) {
            nums1[i]=num1.charAt(len1-1-i)-48;
        }
        for (int i=0;i<len2;i++) {
            nums2[i]=num2.charAt(len2-1-i)-48;
        }
        for (int i=0;i<len1;i++) {
            for (int j=0;j<len2;j++) {
                int i1 = nums1[i] * nums2[j];
                int i2 = i1/10;
                int i3 = i1%10;
                res[i+j]+=i3;
                res[i+j+1]+=i2;
                if (res[i+j]>=10) {
                    res[i+j]-=10;
                    res[i+j+1]++;
                }
                if (res[i+j+1]>=10) {
                    res[i+j+1]-=10;
                    res[i+j+2]++;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (int i=len1+len2-1;i>=0;i--) {
            if (res[i]==0&&first) {
                continue;
            } else if (first) {
                builder.append(res[i]);
                first = false;
            } else {
                builder.append(res[i]);
            }
        }
        return builder.toString();

    }
}
