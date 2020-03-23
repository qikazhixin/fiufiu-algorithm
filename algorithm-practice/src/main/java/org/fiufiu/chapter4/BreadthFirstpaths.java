package org.fiufiu.chapter4;

import org.fiufiu.chapter1.program.model.chapter1.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class BreadthFirstpaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstpaths(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        bfs(g, s);

    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);

        while(!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (int w:g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }

    }






}
