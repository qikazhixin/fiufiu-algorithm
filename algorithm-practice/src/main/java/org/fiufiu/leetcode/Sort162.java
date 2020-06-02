package org.fiufiu.leetcode;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsAnything;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;


/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Sort162 {

    @Test
    public void test(){
        Assert.assertEquals(2, findPeakElement(new int[]{1,2,3,1}));
//        Assert.assertEquals(2, findPeakElement(new int[]{1,2,1,3,5,6,4}));
        Assert.assertThat(findPeakElement(new int[]{1,2,1,3,5,6,4}), anyOf(is(1),is(5)));
    }

    public int findPeakElement(int[] nums) {
        int lo=0,hi=nums.length-1;
        while(true) {
            int mid = (lo+hi)/2;
            boolean left = mid-1<0 || nums[mid] > nums[mid-1];
            boolean right = mid+1>nums.length-1 || nums[mid] > nums[mid+1];
            if (left&&right) {
                return mid;
            } else if(left) {
                lo=mid+1;
            } else {
                hi=mid-1;
            }

        }
    }


}
