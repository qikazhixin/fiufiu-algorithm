package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.TreeNode;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*TreeNode root = new TreeNode(preorder[0]);

        int index=1;

        TreeNode tmp = root;
        while(preorder[index]!=inorder[0]) {
            TreeNode left = new TreeNode(preorder[index]);
            tmp.left = left;
            left.right = tmp;
            tmp=tmp.left;
            index++;
        }
        TreeNode left = new TreeNode(preorder[index]);
        int i1=1;
        while(inorder[i1] != preorder[0]) {
            if (inorder[i1] == tmp.val) {
                if (tmp.right.val == inorder[i1++]) {
                    tmp=tmp.right;
                } else {
                    TreeNode tmp1=tmp;
                    tmp = tmp.right;
                    tmp1.right = new TreeNode(inorder[i1++]);
                }
            }
        }*/


    }
}
