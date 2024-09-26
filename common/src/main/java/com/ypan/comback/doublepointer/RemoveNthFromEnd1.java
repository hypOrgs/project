package com.ypan.comback.doublepointer;

import com.ypan.utils.ListNode;

public class RemoveNthFromEnd1 {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd(listNode, 2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除倒数第k个节点，需要找到倒数第k+1个节点
        ListNode dummy = new ListNode(-1, head);
        ListNode listNode = findFromEnd(dummy, n + 1);
        listNode.next = listNode.next.next;
        return dummy.next;
    }

    // 返回倒数第k个节点
    public static ListNode findFromEnd(ListNode head, int k) {

        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
