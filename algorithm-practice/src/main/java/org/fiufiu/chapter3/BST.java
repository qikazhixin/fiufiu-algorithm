package org.fiufiu.chapter3;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class BST<T extends Comparable<T>, E> {

    private Node root;

    private class Node {

        private T key;
        private E value;
        private Node left;
        private Node right;
        private int n;

        public Node(T key, E value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x ==null) {

            return 0;
        }
        return x.n;
    }

    public E get(T key) {
        return get(root, key);
    }

    private E get(Node x, T key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp>0) {
            get(x.right, key);
        } else if(cmp<0) {
            get(x.left, key);
        } else {
            return x.value;
        }
        return null;
    }

    public void put(T key, E value) {
        root = put(root, key, value);
    }

    private Node put(Node x, T key, E value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp<0) {
            x.left = put(x.left, key, value);
        } else if(cmp>0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.n = size(x.left) + size(x.right);
        return x;
    }

    public T min() {
        return min(root).key;
    }

    public T max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public T floor(T key){
        Node node = floor(root, key);
        if (node ==null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node x, T key) {
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {

        } else if (cmp < 0) {
            return floor(x.left, key);
        } else {
            return x;
        }
        Node t = floor(x.right, key);
        if (t!=null) {
            return t;
        } else {
            return x;
        }

    }


    public T select(int key) {
        return select(root, key).key;
    }

    public Node select(Node x, int key) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if(key - t < 0) {
            return select(x.left, key);
        } else if(key-t==0) {
            return x;
        } else {
            return select(x.right, key-t-1);
        }

    }


    public int rank(T key) {
        return rank(root, key);
    }
    private int rank(Node x, T key){
        if(x==null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0) {
            return size(x.left);
        } else if(cmp<0){
            return rank(x.left, key);
        } else {
            return size(x.left) + 1 + rank(x.right, key);
        }

    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node x) {
        //若

        if (x.left == null) {
            return x.right;
        } else {
            x.left = deleteMin(x.left);
            x.n = size(x.left) + size(x.right) + 1;
            return x;
        }



    }

    public void delete(T key) {
        root = delete(root, key);
    }

    public Node delete(Node x, T key) {
        //若仅有左子树则
        //若有右子树
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0) {
            if (x.right == null) {
                return x.left;
            } else if (x.left == null){
                return x.right;
            } else {
                Node t = x;
                x = min(t.right);
                x.left = t.left;
                x.right = deleteMin(t.right);
            }
        } else if(cmp<0) {
            x.left = delete(x.left, key);
        } else {
            x.right = delete(x.right, key);
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;

    }

    public Iterable<T> keys() {
        return keys(min(), max());
    }

    public Iterable<T> keys(T lo, T hi) {
        Queue<T> ts = new Queue<>();
        keys(root, ts, lo, hi);
        return ts;
    }

    private void keys(Node x, Queue<T> queue, T lo, T hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo<0) {
            keys(x.left, queue, lo, hi);
        }
        if(cmplo <= 0&& cmphi >=0) {
            queue.enqueue(x.key);
        }
        if(cmphi>0) {
            keys(x.right, queue, lo, hi);
        }

    }

}
