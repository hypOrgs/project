package com.ypan.comback.list;

import com.ypan.utils.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        ListNode firstNode;
        ListNode secondNode;
        ListNode threeNode;

        while (curr.next != null && curr.next.next != null) {

            firstNode = curr.next;
            secondNode = curr.next.next;
            threeNode = curr.next.next.next;

            curr.next = secondNode;
            curr.next.next = firstNode;
            firstNode.next = threeNode;
            curr = firstNode;
        }
        return dummyHead.next;
    }
}
