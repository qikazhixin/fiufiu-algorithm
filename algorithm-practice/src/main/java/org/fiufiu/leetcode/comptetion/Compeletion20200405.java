package org.fiufiu.leetcode.comptetion;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Compeletion20200405 {

    @Test
    public void test1() {
        Q1 q1 = new Q1();
        System.out.println(q1.minSubsequence(new int[]{4, 3, 10, 9, 8}));
    }

    class Q1 {

        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
            }
            List<Integer> ls = new ArrayList<>();
            int count=0;
            for (int i = nums.length-1; i >= 0; i--) {
                if (count>sum-count) {
                    break;
                }
                ls.add(nums[i]);
                count+=nums[i];

            }
            return ls;
        }
    }

    @Test
    public void test() {
        Q2 q2 = new Q2();
        Assert.assertEquals(6, q2.numSteps("1101"));
        Assert.assertEquals(1, q2.numSteps("10"));
        Assert.assertEquals(0, q2.numSteps("1"));
    }

    class Q2 {

        public int numSteps(String s) {
            char[] chars = s.toCharArray();
            int count=0;
            for (int i = s.length()-1; i > 0; i--) {
                if (chars[i]=='0') {

                } else if (chars[i]=='1') {
                    count++;
                    chars[i]='0';
                    chars[i-1]++;
                } else if (chars[i]=='2') {
                    chars[i]='0';
                    chars[i-1]++;
                }
            }

            return count+s.length() - 1 + chars[0] - '1';

        }
    }

    @Test
    public void test3() {
        Q3 q3 = new Q3();
//        System.out.println(q3.longestDiverseString(1, 1, 7));
        System.out.println(q3.longestDiverseString(2, 2, 1));
    }

    class Q3 {
        public String longestDiverseString(int a, int b, int c) {
            char a1='a',b1='b',c1='c';
            //define a as max
            if (a>=b&&a>=c){

            } else if (b>a&&b>=c) {
                int tmp=a;
                char tmpc=a1;
                a=b;b=tmp;
                a1=b1;b1=tmpc;
            } else {
                int tmp=a;
                char tmpc=a1;
                a=c;c=tmp;
                a1=c1;c1=tmpc;
            }
            int rest = b+c;
            StringBuilder builder = new StringBuilder();
            while(rest>0) {
                if (a>rest) {
                    builder.append(a1).append(a1);
                    a-=2;

                } else {
                    builder.append(a1);
                    a-=1;
                    if (b>0) {
                        builder.append(b1);
                        b--;
                    } else {
                        builder.append(c1);
                        c--;
                    }
                    rest--;
                }
                if (b>0) {
                    builder.append(b1);
                    b--;
                } else if (c>0){
                    builder.append(c1);
                    c--;
                } else {

                }
                rest--;

            }
            if (a>=2) {
                builder.append(a1).append(a1);
            } else if(a==1) {
                builder.append(a1);
            }
            return builder.toString();

        }
    }
}
