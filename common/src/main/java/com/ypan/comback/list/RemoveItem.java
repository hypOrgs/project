package com.ypan.comback.list;

import com.ypan.utils.ListNode;

/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * <p>
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * <p>
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 * <p>
 *  todo 竟然没做出来
 * 😅
 * 😅
 * #
 */
public class RemoveItem {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(9, new ListNode(8, new ListNode(7)));
        tra(listNode);
    }

    public static void tra(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        tra(head.next);

    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }

            head = head.next;
        }
        return dummy.next;
    }

}
