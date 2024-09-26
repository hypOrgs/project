package com.ypan.comback.doublepointer;

import com.ypan.utils.ListNode;

import java.util.HashSet;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
