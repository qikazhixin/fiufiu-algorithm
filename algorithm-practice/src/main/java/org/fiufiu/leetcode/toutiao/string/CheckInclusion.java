package org.fiufiu.leetcode.toutiao.string;

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

    public boolean checkInclusion(String s1, String s2) {
        int[] ints = new int[26];

        for (int i=0;i<s1.length();i++) {
            ints[s1.charAt(i)-97]++;
        }

        for (int i=0;i<s2.length();) {
            char c = s2.charAt(i);
            if (ints[c-97] == 0) {
                i++;
            } else if(i) {

            } else {
                int[] tmp=ints.clone();
                int count=s1.length()-1;
                tmp[c-97]--;
                while(count>0) {
                    i++;
                    if (tmp[s2.charAt(i)-97] != 0) {
                        tmp[s2.charAt(i)-97]--;
                        count--;
                        continue;
                    } else {
                        break;
                    }
                }
                if (count==0) {
                    return true;
                }
            }
        }

        return false;
    }
}
