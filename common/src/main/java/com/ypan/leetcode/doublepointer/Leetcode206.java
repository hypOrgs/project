package com.ypan.leetcode.doublepointer;


import com.ypan.leetcode.list.ListNode;

public class Leetcode206 {
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
