package org.fiufiu.chapter2;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CubeSum implements Comparable<CubeSum> {

    private int i;
    private int j;
    private int value;

    public CubeSum(int i, int j) {
        this.i = i;
        this.j = j;
        this.value = i*i*i+j*j*j;
    }

    @Override
    public int compareTo(CubeSum o) {
        if (this.value > o.value) {
            return 1;
        } else if(this.value < o.value){
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "CubeSum{" +
                "i=" + i +
                ", j=" + j +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        int n = 10;
        CubeSum[] cubes = new CubeSum[n+1];
        for (int i=0;i<=n;i++) {
            cubes[i]=new CubeSum(i, 0);
        }
        MinPQ<CubeSum> cubeSums = new MinPQ<>(cubes);
        int j=1;int i=0;
        while(!cubeSums.isEmpty()){
            CubeSum min = cubeSums.delMin();
            StdOut.println(min);

            if (min.j < n) {
                cubeSums.insert(new CubeSum(min.i, min.j + 1));
            }
            /*if (j<=n&&i<=n) {
                cubeSums.insert(new CubeSum(i,j++));
            } else if(i<=n) {
                j=1;
                i++;
            } else {
                continue;
            }*/
        }


    }
}
