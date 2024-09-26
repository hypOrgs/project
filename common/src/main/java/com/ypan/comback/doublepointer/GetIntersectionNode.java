package com.ypan.comback.doublepointer;

import com.ypan.utils.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;
        int lengthA = 0;
        int lengthB = 0;

        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }

        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;
        // 始终让链表A成为最长的，后续好操作
        if (lengthB > lengthA) {
            int temp = lengthB;
            lengthB = lengthA;
            lengthA = temp;

            ListNode tempCurr = currB;
            currB = currA;
            currA = tempCurr;

        }

        int n = lengthA - lengthB;
        while (n-- > 0) {
            currA = currA.next;
        }

        while (currA != null) {
            if (currA == currB) {
                return currA;
            }

            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}
