package org.fiufiu.chapter4;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if(vertex == w) {
            return v;
        }
        throw new RuntimeException("invaid");

    }

    public double weight() {
        return weight;
    }

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight < o.weight()) {
            return -1;
        } else if (this.weight > o.weight()) {
            return 1;
        }
        return 0;
    }
}
