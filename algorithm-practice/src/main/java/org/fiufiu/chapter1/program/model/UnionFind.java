package org.fiufiu.chapter1.program.model;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class UnionFind {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " conponents");
    }

    private int[] id;
    private int count;

    //1.quick-find方法 O(n2)
    //2.quick-union方法
    //3.加权qucik-union,记录树的高度
    private int[] sz;

    public UnionFind(int count) {
        this.count = count;
        id = new int[count];
        for (int i=0; i<count; i++){
            id[i] = i;
        }
        //3.method3
        sz = new int[count];
        for (int i=0; i<count; i++){
            sz[i] = 1;
        }
    }

    private void union(int p, int q) {
        //1.method1
        /*int i1 = find(p);
        int i2 = find(q);
        if (i1 == i2) {
            return;
        }
        for (int i=0; i<id.length;i++){
            if(id[i] == i1) {
                id[i] = i2;
            }
        }
        count--;*/
        //2.method2
        /*int rootp = find(p);
        int rootq = find(q);
        if (rootq == rootp) {
            return;
        }
        id[rootp] = rootq;
        count--;*/
        int rootp = find(p);
        int rootq = find(q);
        if (rootq == rootp) {
            return;
        }
        if(sz[rootp]>sz[rootq]) {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        } else {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        }
        count--;
    }

    private int find(int p) {
        //1.method1
        /*return id[p];*/
        //2.method2
        //3.method3
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int count() {
        return count;
    }
}
