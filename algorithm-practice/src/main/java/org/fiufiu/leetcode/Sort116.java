package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class Sort116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node node = connect(root);
        System.out.println();
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        root.left.next = root.right;
        Node next = root.next;
        if (next != null) {
            root.right.next = next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
        /*Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> tmp = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {

            Node ans = queue.poll();
            boolean flag=false;
            if (ans.left == null) {
                flag=true;
            } else {
                tmp.add(ans.left);
                tmp.add(ans.right);
            }
            while (!queue.isEmpty()) {
                Node next = queue.poll();
                ans.next = next;
                ans = next;
                if (!flag) {
                    tmp.add(ans.left);
                    tmp.add(ans.right);
                }
            }
            ans.right = null;

            Queue<Node> queue1=queue;
            queue = tmp;
            tmp = queue1;
            if (flag) {
                queue=queue1;
            }
        }
        return root;*/
    }


}
