package com.ypan.comback.dong.array;

import com.ypan.utils.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;

            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
