package org.fiufiu.leetcode;

import org.junit.Test;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort1014 {

    @Test
    public void test(){
        System.out.println(maxScoreSightseeingPair(new int[]{1, 3, 5}));
    }

    public int maxScoreSightseeingPair(int[] A) {
        int[] sum = new int[A.length];
        int[] minus = new int[A.length];

        for(int i =0;i<A.length;i++){
            sum[i]=A[i]+i;
            minus[i]=A[i]-i;
        }
        int maxS=sum[0];
        int max=sum[0]+minus[1];
        for(int i =1;i<A.length;i++){
            max=Math.max(max, maxS+minus[i]);
            maxS=Math.max(maxS, sum[i]);
        }
        return max;
    }
}
