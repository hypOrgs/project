package com.ypan.leetcode.list;

public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }
        return dummy.next;
    }
}
