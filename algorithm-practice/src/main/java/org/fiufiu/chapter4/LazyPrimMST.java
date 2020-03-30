package org.fiufiu.chapter4;


import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Edge;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {

        pq=new MinPQ<>();
        marked=new boolean[G.V()];
        mst=new Queue<>();
        visit(G, 0);
        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v]&&marked[w]) {
                continue;
            }
            mst.enqueue(e);
            if (!marked[v]){
                visit(G, v);
            }
            if (!marked[w]){
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e:g.adj(v)){
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }

        
    }


}
