package org.fiufiu.exam.leetcode.company.tecent;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SortAndSearch1 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode sortList(ListNode head) {
        //自底向上的归并，没写出来；明天试试快慢指针+自顶向下归并

        int i=1;
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null) {
            len++;
            tmp=tmp.next;
        }
        //
        ListNode tmp1 = head;
        ListNode tmp2=tmp1;

        for(int sz = 1; sz < len; sz=sz*2) {
            for (int lo =0;lo<len -sz;lo+=sz*2) {
                int step = sz;
                tmp2 = tmp1;

            }
        }

        return null;
    }

    private void merge(int size, ListNode t1, ListNode t2) {
        ListNode tmp = null;
        int s1=size,s2=size;
        while(s1>0&&s2>0&&t1!=null&&t2!=null) {
//            if (t1)
        }
    }
}
