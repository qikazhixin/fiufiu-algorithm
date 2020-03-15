package org.fiufiu.leetcode.toutiao.string;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] test1={"flower","flow","flight"};
        String[] test2={"dog","racecar","car"};
        String[] test3={"dog"};

//        System.out.println(test.longestCommonPrefix(test1));
//        System.out.println(test.longestCommonPrefix(test2));
        System.out.println(test.longestCommonPrefix(test3));
    }

    //leetcode
    /*
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);
        }
    }
    return strs[0];
}

     */

    public String longestCommonPrefix(String[] strs) {
        if (strs.length<=0) {
            return "";
        }
        int min=strs[0].length();
        for(int i=1;i<strs.length;i++) {
            min=Math.min(strs[i].length(), min);
        }
        StringBuilder s=new StringBuilder("");
        for (int i=0;i<min;i++) {
            for (int j=1;j<strs.length;j++) {
                if (strs[0].charAt(i)==strs[j].charAt(i)) {

                } else {
                    return s.toString();
                }
            }
            s.append(strs[0].charAt(i));
        }
        return s.toString();
    }
}
