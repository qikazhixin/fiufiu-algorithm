package org.fiufiu.chapter4;

import org.fiufiu.chapter1.program.model.data.Bag;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Graph {

    private final int v;//顶点数
    private int e;//边数
    private Bag<Integer>[] adj;//邻接表

    public Graph(int v) {
        this.v = v;
        this.e=0;
        adj = (Bag<Integer>[])new Bag[v];

    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
