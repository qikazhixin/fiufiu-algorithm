package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.TreeNode;
import org.junit.Test;

public class BuildTree {

    @Test
    public void test() {
//        preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        return buildTree(inorder, 0, preorder.length - 1);
    }
    int[] preorder;
    int index=0;
    private TreeNode buildTree(int [] ori, int left, int right) {
        if (left>right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[index]);
        int i = left;
        for (; i <= right ; i++) {
            if (ori[i]==preorder[index]) {
                break;
            }
        }
        index++;
        treeNode.left = buildTree(ori, left, i-1);
        treeNode.right = buildTree(ori, i+1, right);
        return treeNode;
    }
}
