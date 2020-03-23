package org.fiufiu.chapter4;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
    }
}
