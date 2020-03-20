package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class CountCharacters {

    @Test
    public void test() {

        Assert.assertEquals(6, countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        Assert.assertEquals(10, countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }

    public int countCharacters(String[] words, String chars) {
        int[] ints = new int[26];
        for (int i=0;i<chars.length();i++) {
            ints[chars.charAt(i)-97]++;
        }
        int count=0;
        for (int i=0;i<words.length;i++) {
            int[] tmp=ints.clone();
            boolean b=true;
            for (int j=0;j<words[i].length();j++) {
                if (tmp[words[i].charAt(j)-97]--<=0) {
                    b=false;
                    break;
                }
            }
            if (b) {
                count=count+words[i].length();
            }
        }
        return count;

    }
}
