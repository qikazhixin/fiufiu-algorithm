package org.fiufiu.leetcode;

import org.fiufiu.leetcode.bo.ListNode;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class Sort445 {

    @Test
    public void test() {
        //7-2-4-3 + 5-6-4
        //7-8-0-7
        ListNode listNode = addTwoNumbers(new ListNode(new int[]{7, 2, 4, 3}), new ListNode(new int[]{5, 6, 4}));
        System.out.println(listNode.print());

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        while(l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int size1 = list1.size();
        int size2 = list2.size();
        LinkedList<Integer> longer = null;
        LinkedList<Integer> shorter = null;
        if (size1 > size2) {
            longer = list1;
            shorter = list2;
        } else {
            longer = list2;
            shorter = list1;
        }
        Iterator<Integer> iterator1 = longer.descendingIterator();
        Iterator<Integer> iterator2 = shorter.descendingIterator();
        int tmp = 0;
        ListNode ln = null;
        while(iterator2.hasNext()) {
            Integer i1 = iterator1.next();
            Integer i2 = iterator2.next();

            tmp = i1+i2 + tmp;
            ListNode ln1 = new ListNode(tmp % 10);
            ln1.next = ln;
            ln = ln1;
            tmp = tmp /10;
        }
        while(iterator1.hasNext()) {
            Integer i1 = iterator1.next();
            tmp = i1+tmp;
            ListNode ln1 = new ListNode(tmp % 10);
            ln1.next = ln;
            ln = ln1;
            tmp = tmp /10;
        }
        if (tmp != 0) {
            ListNode ln1 = new ListNode(tmp);
            ln1.next = ln;
            ln = ln1;
        }
        return ln;
    }
}
