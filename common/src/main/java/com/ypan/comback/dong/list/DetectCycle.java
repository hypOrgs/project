package com.ypan.comback.dong.list;

import com.ypan.utils.ListNode;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (fast != head) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
