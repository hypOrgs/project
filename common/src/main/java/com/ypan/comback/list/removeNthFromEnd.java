package com.ypan.comback.list;

import com.ypan.utils.ListNode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        int length = getLength(head);
        for (int i = 0; i < length - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummyHead.next;


    }

    public int getLength(ListNode head) {

        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
}
