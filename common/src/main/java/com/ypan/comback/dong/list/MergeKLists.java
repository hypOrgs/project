package com.ypan.comback.dong.list;

import com.ypan.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1), p = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            p.next = poll;
            if (poll.next != null) {
                queue.add(poll.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
