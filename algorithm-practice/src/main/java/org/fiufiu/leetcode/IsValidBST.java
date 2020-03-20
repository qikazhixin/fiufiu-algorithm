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
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer less, Integer biger) {
        if (node==null) {
            return true;
        }
        //左入
        boolean b=true;
        if (less != null) {
            b=b&&node.val>less;
        }
        if (biger!=null) {
            b=b&&node.val<biger;
        }
        if (!b) {
            return false;
        }
        return isValidBST(node.left, less, node.val)&&isValidBST(node.right, node.val, biger);
    }

    //2.迭代

    //3.中序遍历
}
