package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Sort103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        recursion(1, true, root);
        for (int i = 1; i <= max; i++) {
            ls.add(map.get(i));
        }
        return ls;
    }
    Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    int max=0;
    public void recursion(int floor, boolean left, TreeNode node) {
        if (node==null) {
            return;
        }
        if(map.containsKey(floor)) {
            if (left) {
                map.get(floor).addLast(node.val);
            } else {
                map.get(floor).addFirst(node.val);
            }
        } else {
            LinkedList<Integer> ls = new LinkedList<>();
            ls.add(node.val);
            map.put(floor, ls);
        }
        max=Math.max(max, floor);
        recursion(floor+1, !left, node.left);
        recursion(floor+1, !left, node.right);
    }
}
