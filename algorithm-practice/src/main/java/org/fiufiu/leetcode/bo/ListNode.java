package org.fiufiu.leetcode.bo;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        this.val=nums[0];
        ListNode tmp=this;
        for (int i = 1; i < nums.length; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
    }


    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode tmp=this;
        while(tmp.next!=null) {
            builder.append(tmp.val).append(",");
        }
        builder.append(tmp.val).append("]");
        return builder.toString();
    }
}
