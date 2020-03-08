package org.fiufiu.chapter1.program.model;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class ReverseBinaryTree {

    public static void main(String[] args) {
        ReverseBinaryTree tree = new ReverseBinaryTree();
        tree.test();

    }

    public void test() {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        TreeNode tmp = node.left;
        tmp.left = new TreeNode(1);
        tmp.right = new TreeNode(3);
        node.right = new TreeNode(7);
        tmp = node.right;
        tmp.left = new TreeNode(5);
        tmp.right = new TreeNode(6);
        TreeNode treeNode = invertTree(node);

    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode transfer = new TreeNode(root.val);
        invertTree(root, transfer);
        return transfer;
    }


    public void invertTree(TreeNode x, TreeNode tansf) {

        if (x.left != null) {
            tansf.right = new TreeNode(x.left.val);
            invertTree(x.left, tansf.right);
        }
        if (x.right != null) {
            tansf.left = new TreeNode(x.right.val);
            invertTree(x.right, tansf.left);
        }

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
