package org.fiufiu.leetcode;

public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates duplicates = new DeleteDuplicates();
        duplicates.deleteDuplicates(duplicates.create());
    }

    private ListNode create() {
        return new ListNode(new int[]{1, 2, 2});
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return head;
        }
        ListNode yam = new ListNode(head.val-1);
        yam.next=head;
        ListNode rep=yam;
        ListNode tmp=head;
        int repc = yam.val;
        while(tmp!=null) {
            if (repc==tmp.val) {
                //删除结点
                tmp=tmp.next;
                rep.next=tmp;
            } else {
                repc=tmp.val;
                if (tmp.next==null||tmp.next.val!=repc){
                    rep=tmp;
                }
                tmp=tmp.next;
            }
        }
        return yam.next;
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
