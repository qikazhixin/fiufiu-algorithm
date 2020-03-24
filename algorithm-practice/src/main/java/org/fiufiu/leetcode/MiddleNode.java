package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.ListNode;
import org.junit.Test;

public class MiddleNode {

    @Test
    public void test() {
        System.out.println(middleNode(new ListNode(new int[]{1, 2, 3, 4, 5})).val);
        System.out.println(middleNode(new ListNode(new int[]{1, 2, 3, 4, 5, 6})).val);

    }

    public ListNode middleNode(ListNode head) {
        int mid=1;
        int total=1;
        ListNode pre = head;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp=tmp.next;
            total++;
            if (mid<=total/2) {
                mid++;
                pre=pre.next;
            }
        }
        return pre;
    }
}
