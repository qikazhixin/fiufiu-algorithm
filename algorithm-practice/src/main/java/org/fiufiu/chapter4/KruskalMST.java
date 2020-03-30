package org.fiufiu.chapter4;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.UF;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class KruskalMST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph g) {
        mst=new Queue<>();
        MinPQ<Edge>pq=new MinPQ<>();
        for (Edge e:g.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(g.V());
        while (!pq.isEmpty()&&mst.size()<g.V()-1){
            Edge e = pq.delMin();
            int v=e.either(),w=e.other(v);
            if (uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            mst.enqueue(e);
        }

    }
}
