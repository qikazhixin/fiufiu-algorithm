package org.fiufiu.leetcode;


import org.fiufiu.leetcode.bo.ListNode;
import org.junit.Test;

import java.util.Stack;

public class Sort143 {

    @Test
    public void test() {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        reorderList(head);
        reorderList(head1);
        System.out.println(head.print());
        System.out.println(head1.print());
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        if (size <= 1) {
            return;
        }
        int i = 0;
        tmp = head;
        ListNode pre = tmp;
        while(i<=size/2) {
            tmp = tmp.next;
            ListNode pop = stack.pop();
            pre.next = pop;
            pop.next = tmp;
            pre = tmp;
            i++;
        }
        if (size%2==0) {
            pre.next = null;
        } else {
            pre.next = tmp.next;
            pre.next.next = null;
        }

    }
}
