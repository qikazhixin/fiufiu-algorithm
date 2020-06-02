package org.fiufiu.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort887 {

    @Test
    public void test() {
//        Assert.assertEquals(2, superEggDrop(1,2));
        Assert.assertEquals(3, superEggDrop(2,4));
        Assert.assertEquals(1, superEggDrop(2,1));
        Assert.assertEquals(2, superEggDrop(2,2));
        Assert.assertEquals(3, superEggDrop(2,6));
        Assert.assertEquals(4, superEggDrop(3,14));
        Assert.assertEquals(4, superEggDrop(2,7));
    }

    public int superEggDrop(int K, int N) {
        N=N+1;
        int count=0;
        while(N>0) {
            if (N<=2) {
                return count+1;
            }
            if (K==1) {
                count+=(N-1);
                break;
            } else {
                 if (N%2==0) {
                     N=N/2;
                 } else {
                     N=(N-1)/2;
                 }
                 K--;
                 count++;
            }
        }
        return count;
    }
}
