package org.fiufiu.leetcode.toutiao.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        String test1 = "abca";
        String test2 = "bbbbbbb";
        String test3 = "pwwkewbcw";
        System.out.println(test.lengthOfLongestSubstring(test1));
        System.out.println(test.lengthOfLongestSubstring(test2));
        System.out.println(test.lengthOfLongestSubstring(test3));
    }

    //leetcode
    /*
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
     */

    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int start=-1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char key = s.charAt(i);
            Integer integer = map.get(key);

            if (integer==null) {
                map.put(key, i);
            } else {
                if (integer>=start) {
                    max=Math.max(i-1-start, max);
                    start=integer;
                    map.put(key, i);
                } else {
                    map.put(key, i);
                }
            }
            if (i==s.length()-1) {
                if (integer==null) {
                    integer = 0;
                }
                System.out.println("start:"+start+",i:"+integer);
                max=Math.max(max, i-Math.max(start, integer-1));
            }

        }
        return max;

    }
}
