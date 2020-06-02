package org.fiufiu.exam.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort1431 {

    @Test
    public void test() {
        //[true,true,true,false,true]
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        //[true,false,false,false,false]
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        //[true,false,true]
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            max = max > i ? max : i;
        }
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int i : candies) {
            res.add(i + extraCandies >= max);
        }
        return res;
    }
}
