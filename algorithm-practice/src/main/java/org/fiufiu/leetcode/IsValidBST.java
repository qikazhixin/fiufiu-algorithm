package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class IsValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isValidBST(root.left, root.val, true)
                &&isValidBST(root.right, root.val, false);
    }

    public boolean isValidBST(TreeNode node, int last, boolean le) {
        if (node==null) {
            return true;
        }
        boolean b;
        if (le) {
            b=node.val<last;
        } else {
            b=node.val>last;
        }

        return b&&isValidBST(node.left, node.val, true)
                &&isValidBST(node.right, node.val, false);
    }
}
