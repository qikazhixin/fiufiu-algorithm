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
//        Assert.assertTrue(checkInclusion("ab", "eidboaboo"));
//        Assert.assertFalse(checkInclusion("ab", "eidboaoo"));
        Assert.assertTrue(checkInclusion("abcdxabcde", "abcdeabcdx"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s1.length();i++) {
            Integer integer = map.get(s1.charAt(i));
            if (integer ==null) {
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), integer+1);
            }
        }
        int len = s1.length();
        for (int i=0;i<=s2.length()-len;i++) {
            //开始滑动窗口
            Map<Character, Integer> tmp = new HashMap<>();
            if (map.containsKey(s2.charAt(i))) {
                boolean b=true;
                for(int j=i;j<i+len;j++) {
                    char key = s2.charAt(j);
                    if (map.containsKey(key)) {
                        if (tmp.get(key)== null) {
                            tmp.put(key ,map.get(key)-1);
                        } else if(tmp.get(key)<=0){
                            b=false;
                            break;
                        } else {
                            tmp.put(key, tmp.get(key)-1);
                        }
                    } else {
                        b=false;
                        break;
                    }
                }
                if (b) {
                    return b;
                }
            }
        }
        return false;
    }
}
