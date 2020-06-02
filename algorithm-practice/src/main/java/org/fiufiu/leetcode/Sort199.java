package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sort199 {

    @Test
    public void test() {
//        new TreeNode(new Integer[]{1,2,3,null,5,null,4});
        TreeNode head = new TreeNode(1);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(5);
//        node3.right = node4;
        head.left = node3;
//        node1.right = node2;
//        head.right = node1;
        List<Integer> integers = rightSideView(head);
        System.out.println(integers);
    }

    public List<Integer> rightSideView(TreeNode root) {

        //o(N)
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }
        TreeNode tmp = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tmp);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll == tmp) {
                if (queue.isEmpty()) {
                    break;
                }
                poll = queue.poll();
                res.add(poll.val);
                queue.add(tmp);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
        }
        return res;

    }
}
