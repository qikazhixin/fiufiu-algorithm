package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/

public class Compeletion20200301 {

    //https://leetcode-cn.com/contest/weekly-contest-178/problems/how-many-numbers-are-smaller-than-the-current-number/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i=0;i<len;i++) {
            int sum=0;
            for (int j=0;j<len;j++) {
                if (nums[j]<nums[i]) {
                    sum++;
                }
            }
            res[i]=sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Compeletion20200301 comp = new Compeletion20200301();
//        String[] strings = {"ABC", "BCA"};
//        String[] strings = {"BCA","CAB","CBA","ABC","ACB","BAC"};
//        String[] strings = {"WXYZ","XYZW"};
        String[] strings = {"FVSHJIEMNGYPTQOURLWCZKAX","AITFQORCEHPVJMXGKSLNZWUY","OTERVXFZUMHNIYSCQAWGPKJL","VMSERIJYLZNWCPQTOKFUHAXG","VNHOZWKQCEFYPSGLAMXJIUTR","ANPHQIJMXCWOSKTYGULFVERZ","RFYUXJEWCKQOMGATHZVILNSP","SCPYUMQJTVEXKRNLIOWGHAFZ","VIKTSJCEYQGLOMPZWAHFXURN","SVJICLXKHQZTFWNPYRGMEUAO","JRCTHYKIGSXPOZLUQAVNEWFM","NGMSWJITREHFZVQCUKXYAPOL","WUXJOQKGNSYLHEZAFIPMRCVT","PKYQIOLXFCRGHZNAMJVUTWES","FERSGNMJVZXWAYLIKCPUQHTO","HPLRIUQMTSGYJVAXWNOCZEKF","JUVWPTEGCOFYSKXNRMHQALIZ","MWPIAZCNSLEYRTHFKQXUOVGJ","EZXLUNFVCMORSIWKTYHJAQPG","HRQNLTKJFIEGMCSXAZPYOVUW","LOHXVYGWRIJMCPSQENUAKTZF","XKUTWPRGHOAQFLVYMJSNEIZC","WTCRQMVKPHOSLGAXZUEFYNJI"};
        System.out.println(comp.rankTeams(strings));
//        comp.test3();
    }

    public String rankTeams(String[] votes) {
        int voters = votes.length;
        int teams = votes[0].length();
        Map<Character, int[]> map = new HashMap<>(teams);

        String first = votes[0];
        for(int i=0;i<teams;i++) {
            int[] integers = new int[teams];
            integers[i]++;
            map.put(first.charAt(i), integers);
        }
        for(int i=1;i<voters;i++) {
            for(int j=0;j<teams;j++) {
                char key = votes[i].charAt(j);
                map.get(key)[j]++;
            }
        }

        String collect = map.entrySet().stream().sorted(new Comparator<Map.Entry<Character, int[]>>() {
            @Override
            public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character, int[]> o2) {

                int[] ranks1 = o1.getValue();
                int[] ranks2 = o2.getValue();
                //根据投票排序
                for (int i = 0; i < teams; i++) {
                    if (ranks1[i] != ranks2[i]) {
                        return ranks2[i] - ranks1[i];
                    }
                }
                //字母顺序排序
                return o1.getKey() - o2.getKey();

            }
        }).map(characterEntry -> {
            return String.valueOf(characterEntry.getKey());
        }).collect(Collectors.joining());

        return collect;
    }

    private char findRank(Map<Character, int[]> map, int rank) {
        return map.entrySet().stream().max(new Comparator<Map.Entry<Character, int[]>>() {
            @Override
            public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character, int[]> o2) {
                int tmp=rank;
                while(tmp<o1.getValue().length) {

                    if (o1.getValue()[tmp] > o2.getValue()[tmp]) {
                        return 1;
                    } else if(o1.getValue()[tmp] < o2.getValue()[tmp]){
                        return -1;
                    } else {
                        tmp++;
                    }
                }
                if (o1.getKey() < o2.getKey()) {
                    return 1;
                } else {
                    return -1;
                }

            }
        }).get().getKey();
    }

    public void test3() {
        ListNode listNode = new ListNode(new int[]{7, 6, 6});

        Integer[] ints = {1, 7, 4, null, 1, 2, null, 3, 6, null, null, 3, null, 7, null, null, null, 10};
        TreeNode tree = createBinaryTreeByArray(ints, 0);
        boolean b = isSubPath(listNode, tree);
        System.out.println(b);
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        public ListNode(int[] ints) {
          val=ints[0];
          ListNode tmp=this;
          for (int i=1;i<ints.length;i++) {
              tmp.next=new ListNode(ints[i]);
              tmp=tmp.next;
          }

        }
    }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

  }

    private TreeNode createBinaryTreeByArray(Integer []array,int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }


    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) {
            return false;
        }
        if (head.val == root.val) {
            boolean b = matchSub(head.next, root.left) || matchSub(head.next, root.right);
            if (b) {
                return true;
            }

        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }

    boolean matchSub(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }

        if (head.val == node.val) {
            return matchSub(head.next, node.left) || matchSub(head.next, node.right);

        } else {
            return false;
        }
    }


}
