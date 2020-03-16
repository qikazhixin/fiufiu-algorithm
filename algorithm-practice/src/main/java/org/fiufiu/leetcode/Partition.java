package org.fiufiu.leetcode;

public class Partition {


    public static void main(String[] args) {
        Partition partition = new Partition();
        partition.partition(partition.createTest(), 2);

    }

    private ListNode createTest() {
        return new ListNode(new int[]{1,1});
    }


    public ListNode partition(ListNode head, int x) {
        //两个指针；一个指向小于，一个指向当前遍历；
        //当前指针和target大小，若小于则进行指针替换；大于前进
        //注意边界
        ListNode less=null;
        ListNode tmp=head;
        ListNode pre=head;

        //首先找到第一个小于的作为head
        while(tmp!=null&&tmp.val>=x) {
            pre=tmp;
            tmp=tmp.next;
        }
        if (tmp==null) {
            return head;
        }
        ListNode restart=tmp.next;
        tmp.next=head;
        head=tmp;
        pre.next=restart;
        tmp=restart;
        less=head;
        while(tmp!=null) {
            if (tmp.val>=x) {
                pre=tmp;
                tmp=tmp.next;
            } else {
                if(pre==less) {
                    less=pre=tmp;
                    tmp=tmp.next;
                } else {
                    pre.next=tmp.next;
                    tmp.next=less.next;
                    less.next=tmp;
                    less=tmp;
                    tmp=pre.next;

                }
            }
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        public ListNode(int[]is) {
            this.val=is[0];
            ListNode tmp=this;
            for (int i=1;i<is.length;i++) {
                tmp.next=new ListNode(is[i]);
                tmp=tmp.next;
            }
        }
    }
}
