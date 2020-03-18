package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class InorderTraversal {

    @Test
    public void test() {
        //[1,3,2]
    }
    //中序左-中-右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root != null) {
            inorderTraversal(root, ls);
        }
        return ls;
    }

    private void inorderTraversal(TreeNode root, List<Integer> ls) {
        if (root.left!=null) {
            inorderTraversal(root.left, ls);
        }
        ls.add(root.val);
        if (root.right!=null) {
            inorderTraversal(root.right, ls);
        }
    }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
}
