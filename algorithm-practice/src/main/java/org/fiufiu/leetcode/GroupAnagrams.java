package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs=new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams anagrams = new GroupAnagrams();
        List<List<String>> lists = anagrams.groupAnagrams(strs);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Inner, List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            int[] tmp=new int[26];
            String str = strs[i];
            for (int j=0;j<str.length();j++) {
                tmp[str.charAt(j)-97]++;
            }
            Inner inner = new Inner(tmp);
            List<String> strings = map.get(inner);
            if (strings == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(inner, list);
            } else {
                strings.add(str);
            }
        }
        List<List<String>> collect = map.entrySet().stream().map(listEntry -> {
            return listEntry.getValue();
        }).collect(Collectors.toList());
        return collect;
    }

    class Inner{
        int[] chars = new int[26];

        public Inner(int[] chars) {
            this.chars = chars;
        }

        public int[] getChars() {
            return chars;
        }


        @Override
        public int hashCode() {
            int sum=0;
            for (int i=0;i<26;i++) {
                sum=sum+i*chars[i];
            }
            return sum;
        }

        @Override
        public boolean equals(Object obj) {
            int[] charss = ((Inner) obj).getChars();
            for (int i=0;i<26;i++) {
                if (chars[i]==charss[i]) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
