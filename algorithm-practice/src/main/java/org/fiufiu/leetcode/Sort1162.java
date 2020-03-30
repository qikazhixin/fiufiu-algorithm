package org.fiufiu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort1162 {

    class Lalo{
        public int x;
        public int y;

        public Lalo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<Lalo> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1) {
                    queue.add(new Lalo(j, i));
                }
            }
        }
        if(queue.size()==0||queue.size()==n*n){
            return -1;
        }
        int [] px= {1,0,-1,0};
        int [] py= {0,1,0,-1};

        Lalo last=null;
        while(!queue.isEmpty()){
            Lalo poll = queue.poll();
            last=poll;
            for (int i = 0; i < 4; i++) {
                int ix = poll.x + px[i];
                int iy = poll.y + py[i];
                if (ix>=0&&ix<n&&iy>=0&&iy<n&&grid[iy][ix]==0) {
                    grid[iy][ix]=grid[poll.y][poll.x]+1;
                    queue.add(new Lalo(ix, iy));
                }
            }


        }
        return grid[last.y][last.x]-1;

        /*int max=0;
        if (queue.size()==0||queue.size()==x*y){
            return -1;
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j]==0) {
                    int min=Integer.MAX_VALUE;
                    for (Lalo l:queue) {
                        Math.min(min, Math.abs(l.x-j)+Math.abs(l.y-i));
                    }
                    max=Math.max(max, min);
                }
            }
        }
        return max;*/
    }
}
