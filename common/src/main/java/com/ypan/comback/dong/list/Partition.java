package com.ypan.comback.dong.list;

import com.ypan.utils.ListNode;

public class Partition {
    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode l1 = dummy1, l2 = dummy2, p = head;

        while (p != null) {

            if (p.val < x) {
                l1.next = p;
                l1 = l1.next;
            } else {
                l2.next = p;
                l2 = l2.next;
            }

            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        l1.next = dummy2.next;
        return dummy1.next;
    }
}
