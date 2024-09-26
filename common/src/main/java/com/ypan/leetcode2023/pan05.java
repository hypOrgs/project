package com.ypan.leetcode2023;

import com.ypan.leetcode.list.ListNode;

public class pan05 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyListNode = new ListNode(-1, head);
        ListNode pre = dummyListNode;
        ListNode curr = dummyListNode.next;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return dummyListNode.next;
    }
}
