package com.ypan.comback.dong.list;

import com.ypan.utils.ListNode;

import javax.annotation.Resource;

public class Partition1 {
    public ListNode partition(ListNode head, int x) {

        ListNode p1 = new ListNode(-1), dummy1 = p1;
        ListNode p2 = new ListNode(-1), dummy = p2;
        ListNode p = head;

        while (p != null) {
            if (p.val > x) {
                p2.next = p;
                p2 = p2.next;
            } else {
               p1.next = p;
               p1 = p1.next;
            }

            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy.next;
        return dummy1.next;
    }

    }
