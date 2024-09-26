package com.ypan.comback.list;

import com.ypan.utils.ListNode;

public class ReverList {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;

    }
}
