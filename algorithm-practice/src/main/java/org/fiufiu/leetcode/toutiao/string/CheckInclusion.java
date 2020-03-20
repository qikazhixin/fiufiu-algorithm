package org.fiufiu.leetcode.toutiao.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CheckInclusion {

    public static void main(String[] args) {

        CheckInclusion test = new CheckInclusion();
//        String s1 = "ab", s2 = "eidbaooo";
        String s1= "ab", s2 = "eidboaboo";
        System.out.println(test.checkInclusion(s1, s2));
    }

    @Test
    public void test() {
        String s1= "ab", s2 = "eidboaboo";
        Assert.assertTrue(checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {


        return false;
    }
}
