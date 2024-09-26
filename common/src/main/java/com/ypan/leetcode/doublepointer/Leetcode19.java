package com.ypan.leetcode.doublepointer;

import com.ypan.leetcode.list.ListNode;
import springfox.documentation.service.Header;

public class Leetcode19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int length = getListLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    public static int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
