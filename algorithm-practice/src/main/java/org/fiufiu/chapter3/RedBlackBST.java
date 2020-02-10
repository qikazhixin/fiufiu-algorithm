package org.fiufiu.chapter3;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class RedBlackBST<T extends Comparable<T>, E> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        private T key;
        private E val;
        private  Node left, right;
        private int N;
        private boolean color;

        public Node(T key, E val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x==null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;

    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.left);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    public void put(T key, E val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, T key, E val) {
        if (x == null) {
            return new Node(key, val, 1 ,RED);
        }
        int cmp = key.compareTo(x.key);
        if (cmp<0) {
            put(x.left, key, val);
        } else if (cmp>0) {
            put(x.right, key, val);
        } else {
            x.val = val;
        }
        if (!isRed(x.left)&&isRed(x.right)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left)&&isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left)&&isRed(x.right)) {
            flipColors(x);
        }
        x.N = 1 + size(x.right) + size(x.left);
        return x;


    }

    /*private Node moveRedLeft(Node h) {

    }

    public void deleteMin() {

    }

    private Node deleteMin(Node h) {

    }

    private Node balance(Node h) {

    }

    private void flipColorsH(Node h) {

    }*/
}
