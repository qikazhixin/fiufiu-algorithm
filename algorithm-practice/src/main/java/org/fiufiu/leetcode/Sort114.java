package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Sort114 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        System.out.println();
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
            node.left = null;
            node.right = stack.isEmpty() ? null : stack.peek();
        }

    }
}
