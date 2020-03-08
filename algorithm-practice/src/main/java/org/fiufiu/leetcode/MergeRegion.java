package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class MergeRegion {

    public static void main(String[] args) {
        MergeRegion region = new MergeRegion();
        int[][] ints = {{2,6},{2,5},{1,3},{8,10}};

        int[][] merge = region.merge(ints);
        System.out.println(merge);

    }
/* leetcode answer
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }*/


    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int [] ex=new int[2];
        ex=intervals[0];
        List<int[]> list=new ArrayList<>();
        for (int i=1;i<len;i++) {
            if (intervals[i][0] <= ex[1] && intervals[i][1] <= ex[1]) {

            } else if (intervals[i][0] <= ex[1] && intervals[i][1] > ex[1]) {
                ex[1] = intervals[i][1];
            } else {
                list.add(ex);
                ex=intervals[i];
            }
        }
        list.add(ex);
        int[][] res = new int[list.size()][2];
        for (int i=0;i<list.size();i++) {
            res[i]=list.get(i);
        }
        return res;

    }


}
