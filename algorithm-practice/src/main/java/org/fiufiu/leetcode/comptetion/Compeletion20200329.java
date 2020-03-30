package org.fiufiu.leetcode.comptetion;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Compeletion20200329 {



    class q1{
        public int findLucky(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i],map.get(arr[i])+1);
                } else {
                    map.put(arr[i],1);
                }
            }
            int max=-1;
            for (Integer key:map.keySet()) {
                if (key.equals(map.get(key))){
                    max=Math.max(max, key);
                }
            }
            return max;
        }

    }

    @Test
    public void test(){
        Q2Sort5369 q2 = new Q2Sort5369();
        Assert.assertEquals(3, q2.numTeams(new int[]{2,5,3,4,1}));
    }

    class Q2Sort5369 {

        public int numTeams(int[] rating) {
            //三遍遍历
            int count=0;
            for (int i = 0; i < rating.length-2; i++) {
                for (int j = i+1; j < rating.length-1; j++) {
                    for (int k = j+1; k < rating.length; k++) {
                        if (rating[i]>rating[j]&&rating[j]>rating[k]){
                            count++;
                        }
                        if (rating[i]<rating[j]&&rating[j]<rating[k]){
                            count++;
                        }
                    }
                }
            }
            return count;

        }
    }
}
