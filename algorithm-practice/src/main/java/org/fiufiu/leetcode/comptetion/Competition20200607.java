package org.fiufiu.leetcode.comptetion;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Competition20200607 {

    class Q1 {

        public int[] shuffle(int[] nums, int n) {
            int[] tmp = new int[n];
            for(int i=0;i<n;i++){
                tmp[i]=nums[n+i];
            }

            for(int i=2*n-1;i>0;i--){
                if(i%2==0) {
                    nums[i]=nums[i/2];
                } else {
                    nums[i]=tmp[i/2];
                }
            }
            return nums;

        }

    }

    @Test
    public void testQ2() {
        new Q2().getStrongest(new int[]{-7,22, 17, 3}, 2);
    }

    class Q2 {

        public int[] getStrongest(int[] arr, int k) {
            Arrays.sort(arr);
            if (arr.length%2==0) {

            }
            int mid = arr[(arr.length -1)/2];
            int[] res = new int[k];
            int le=0, ri=arr.length-1, i=0;
            while(i<k&&le<=ri) {
                int b = Math.abs(arr[le]-mid)-Math.abs(arr[ri]-mid);
                if(b>0) {
                    res[i++]=arr[le];
                    le++;

                } else {
                    res[i++]=arr[ri];
                    ri--;
                }
            }
            return res;
        }
    }

    @Test
    public void testQ3() {
        BrowserHistory history = new BrowserHistory("leetcode");
        history.visit("google");
        history.visit("facebook");
        history.visit("youtube");
        history.back(1);
        history.back(1);
        history.forward(1);
        history.visit("linkedin");
        history.forward(2);
        history.back(2);
        history.back(7);
    }

    //Q3
    class BrowserHistory {

        class ListNode {
            String url;
            ListNode pre;
            ListNode next;

            public ListNode(String url) {
                this.url = url;
            }
        }

        private ListNode head;
        private int tsize = 0;
        private ListNode now;
        private int rindex;

        public BrowserHistory(String homepage) {
            head = new ListNode(homepage);
            tsize++;
            now = head;
            rindex = 1;
        }

        public void visit(String url) {
            //now 就是在末尾；
            ListNode tmp = new ListNode(url);
            tmp.pre = now;
            now.next = tmp;
            now = tmp;
            if (rindex != tsize) {
                tsize = rindex;
            }
            rindex++;
            tsize++;
            //now在中间
        }

        public String back(int steps) {
            while(steps>0 && rindex>1) {
                now = now.pre;
                rindex--;
                steps--;
            }
            return now.url;

        }

        public String forward(int steps) {
            while(steps>0&&now.next!=null) {
                now=now.next;
                rindex++;
                steps--;
            }
            return now.url;
        }
    }

}
