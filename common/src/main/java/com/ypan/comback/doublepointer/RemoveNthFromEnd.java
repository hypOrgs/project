package com.ypan.comback.doublepointer;

import com.ypan.utils.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = getLength(head);
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr =  dummyHead;
        for (int i = 0; i < length - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummyHead.next;

    }

    public int getLength(ListNode head) {

        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        return n;
    }
}
