package org.fiufiu.chapter1.program.model.chapter5;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class TriesST<E> {


    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public E get(String key) {
        Node x = get(root, key, 0);
        if (x==null) {
            return null;
        }
        return (E) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x==null) {
            return null;
        }
        if (d==key.length()) {
            return x;
        }
        return get(x.next[key.charAt(d)], key, d++);

    }

    private void put(String key, E val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, E val, int d) {
        if (x==null) {
            x=new Node();
        }

        if (d==key.length()) {
            x.val=val;
            return x;
        }
        char c=key.charAt(d);
        x.next[c]=put(x.next[c], key, val, d++);
        return x;

    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    private Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x==null) {
            return;
        }
        if(x.val!=null) {
            q.enqueue(pre);
        }
        for (char c=0;c<R;c++) {
            collect(x.next[c], pre+c, q);
        }
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d==key.length()) {
            x.val=null;
        } else {
            char c= key.charAt(d);
            x.next[c]=delete(x.next[c],key,d+1);
        }
        if (x.val!=null) {
            return x;
        }
        for (char c= 0;c<R;c++) {
            if (x.next[c]!=null) {
                return x;
            }
        }
        return null;
    }
}
