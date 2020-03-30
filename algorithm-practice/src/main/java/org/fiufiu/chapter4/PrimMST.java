package org.fiufiu.chapter4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class PrimMST {

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph g) {
        edgeTo=new Edge[g.V()];
        distTo=new double[g.V()];
        marked=new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        pq=new IndexMinPQ<>(g.V());
        distTo[0]=0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(g,pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v]=true;
        for (Edge e:g.adj(v)) {
            int w=e.other(v);
            if (marked[w]){
                continue;
            }
            if (e.weight()<distTo[w]){
                edgeTo[w]=e;
                distTo[w]=e.weight();
                if (pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                } else {
                    pq.insert(w,distTo[w]);
                }

            }

        }

    }
}
