package org.fiufiu.chapter4;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        
        marked = new boolean[G.getV()];
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w:g.adj(v)
             ) {
            if (!marked[w]) dfs(g, w);
        }

    }
}
