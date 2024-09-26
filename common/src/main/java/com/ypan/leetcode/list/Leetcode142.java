package com.ypan.leetcode.list;

import java.util.HashSet;

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {

        // todo 可以使用O(1)空间解决吗？

        HashSet set = new HashSet();
        while (head != null) {
            boolean b = set.add(head);
            if (!b) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
