package com.ypan.leetcode.list;

import java.util.concurrent.atomic.AtomicInteger;

public class Leetcode19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getListLength(head);
        ListNode curr = head;
        ListNode dummy = new ListNode(-1, head);
        for (int i = 1; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;

    }

    public static int getListLength(ListNode head) {

        if (head == null) {
            return 0;
        }
        AtomicInteger count = new AtomicInteger(1);
        while (head != null) {
            count.incrementAndGet();
            head = head.next;
        }
        return count.get();
    }
}
