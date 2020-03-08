package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class RotateList {

    public static void main(String[] args) {
        RotateList testReverseBetween = new RotateList();
        ListNode head = testReverseBetween.createListNode();
//        testReverseBetween.reverseBetween(head, 2, 4);
        testReverseBetween.reverseBetween(head, 1, 2);
        System.out.println(head);
    }

    private ListNode createListNode() {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next=l1;
//        ListNode l2 = new ListNode(3);
//        l1.next=l2;
//        ListNode l3 = new ListNode(4);
//        l2.next=l3;
//        ListNode l4 = new ListNode(5);
//        l3.next=l4;
        return head;
    }

/*
    //leetcode
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;

    }*/


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n==1) {
            return head;
        }
        int start = 1;
        ListNode tmp=head;
        ListNode last;
        while(start < m-1) {
            start++;
            tmp=tmp.next;
        }
        ListNode bef;
        ListNode mid;
        if (m==1) {
            last=null;
            bef=tmp.next;
            mid=tmp;
        } else {
            last=tmp;
            tmp=tmp.next;
            bef=tmp.next;
            mid=tmp;
            start++;
        }
        while(start<=n-1) {
            mid=bef;
            bef=bef.next;
            mid.next=tmp;
            tmp=mid;
            start++;
        }
        if (last!= null) {

            tmp=last.next;
            last.next=mid;
            tmp.next=bef;
        } else {
            tmp = head;
            head = mid;
            tmp.next=bef;
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmp=head;
        if (tmp==null || tmp.next==null) {
            return head;
        }
        int sum = 1;
        while(tmp.next!=null) {
            sum++;
            tmp=tmp.next;
        }
        int move = k%sum;
        if (move==0) {
            return head;
        }
        move = sum-move;

        ListNode first=head;
        ListNode before=null;
        for (int i=0;i<move;i++) {
            before=head;
            head=head.next;
        }
        tmp.next=first;
        before.next=null;
        return head;

    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        /*@Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[").append(val);
            ListNode tmp=this;
            while (tmp.next!=null) {
                tmp=tmp.next;
                stringBuilder.append(",").append(tmp.val);
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }*/
    }
}
