package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(12);
        System.out.println(levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ls = new ArrayList<>();
        help(root, 0);
        return ls;
    }
    List<List<Integer>> ls;
    private void help(TreeNode node, int index) {
        if (node == null) {
            return;
        }
        if (ls.size()<=index) {
            ls.add(new ArrayList<>());
        }
        List<Integer> list = ls.get(index);
        list.add(node.val);
        help(node.left, index+1);
        help(node.right, index+1);
    }

    //leetcode
    /*class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<List<Integer>>();
            if (root == null) return levels;

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while ( !queue.isEmpty() ) {
                // start the current level
                levels.add(new ArrayList<Integer>());

                // number of elements in the current level
                int level_length = queue.size();
                for(int i = 0; i < level_length; ++i) {
                    TreeNode node = queue.remove();

                    // fulfill the current level
                    levels.get(level).add(node.val);

                    // add child nodes of the current level
                    // in the queue for the next level
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                // go to next level
                level++;
            }
            return levels;
        }
    }*/
}
