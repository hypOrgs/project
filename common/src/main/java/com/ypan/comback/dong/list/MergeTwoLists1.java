package com.ypan.comback.dong.list;

import com.ypan.utils.ListNode;

public class MergeTwoLists1 {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1), p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        if (l1 == null) {
            p.next = l2;
        }

        if (l2 == null) {
            p.next = l1;
        }
        return dummy.next;
    }
}
