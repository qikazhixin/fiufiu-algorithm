package org.fiufiu.chapter4;

import edu.princeton.cs.algs4.Bag;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class EdgeWeightedGraph {

    private final int v;
    private int e;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (Bag<Edge>[])new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public void addEdge(Edge e){
        int v = e.either(), w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.e++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }
}
