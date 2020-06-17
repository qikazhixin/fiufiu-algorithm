package org.fiufiu.exam.leetcode.company.tecent;

import org.fiufiu.exam.leetcode.company.TreeNode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SortAndSearch5 {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(maxDepth(node.left, depth+1), maxDepth(node.right, depth+1));

    }
}
