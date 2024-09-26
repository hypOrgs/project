package com.ypan.project.leetcode.simple;

/**
 * question:
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 思路：
 * 1.关键在于使用虚拟头节点。
 * 2.记得移动cur指针。
 */
public class LeetCode21 {


//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        if (l1 == null && l2 == null) {
//            return null;
//        }
//
//        ListNode dummyHead = new ListNode(0);
//        ListNode cur = dummyHead;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        while (l1 != null) {
//            cur.next = l1;
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            cur.next = l2;
//            l2 = l2.next;
//        }
//        return dummyHead.next;
//    }
}
