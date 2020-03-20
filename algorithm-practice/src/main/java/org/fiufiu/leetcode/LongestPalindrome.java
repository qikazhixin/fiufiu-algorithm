package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindrome {

    @Test
    public void test() {
        Assert.assertEquals(7, longestPalindrome("abccccdd"));
        String s = "civilwartestingwhetherthatnaptionoranynartionsoco" +
                "nceivedandsodedicatedcanlongendureWeareqmetonagreatbat" +
                "tlefiemldoftzhatwarWehavecometodedicpateaportionofthat" +
                "fieldasafinalrestingplaceforthosewhoheregavetheirlives" +
                "thatthatnationmightliveItisaltogetherfangandproperthatw" +
                "eshoulddothisButinalargersensewecannotdedicatewecannotc" +
                "onsecratewecannothallowthisgroundThebravelmenlivingandd" +
                "eadwhostruggledherehaveconsecrateditfaraboveourpoorponwe" +
                "rtoaddordetractTgheworldadswfilllittlenotlenorlongremember" +
                "whatwesayherebutitcanneverforgetwhattheydidhereItisforusthe" +
                "livingrathertobededicatedheretotheulnfinishedworkwhichtheywho" +
                "foughtherehavethusfarsonoblyadvancedItisratherforustobehereded" +
                "icatedtothegreattdafskremainingbeforeusthatfromthesehonoreddea" +
                "dwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfull" +
                "measureofdevotionthatweherehighlyresolvethatthesedeadshallnothave" +
                "diedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandth" +
                "atgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Assert.assertEquals(983, longestPalindrome(s));
    }

    //leetcode
    /*public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }*/

    public int longestPalindrome(String s) {
        int[] ints = new int[52];
        for(int i=0;i<s.length();i++) {
            ints[setChar(s.charAt(i))]++;
        }
        int count=0;
        int has=0;
        for (int i=0;i<52;i++) {
            if (ints[i]%2==0) {
                count+=ints[i];
            } else {
                has=1;
                count+=ints[i]-1;
            }
        }
        return count+has;
    }

    private int setChar(char c) {
        if (c>=65&&c<=90) {
            return c-65;
        }
        if (c>=97&&c<=122) {
            return c-97+26;
        }
        return -1;
    }
}
