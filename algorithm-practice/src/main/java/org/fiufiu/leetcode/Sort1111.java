package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort1111 {

    @Test
    public void test(){
        System.out.println(Arrays.toString(maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        int a=0,b=0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if (c=='(') {
                if (a==b){
                    res[i]=0;
                    a++;
                } else {
                    res[i]=1;
                    b++;
                }
            } else {
                if (a==b){
                    res[i]=1;
                    b--;
                } else {
                    res[i]=0;
                    a--;
                }
            }
        }
        return res;
    }
}
