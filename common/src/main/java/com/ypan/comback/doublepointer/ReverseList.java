package com.ypan.comback.doublepointer;

import com.ypan.utils.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
        }
    }
