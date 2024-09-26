package com.ypan.project.zhuoshen.sort;

import java.util.Stack;

public class SingleLinkList {

    public static class Node {

        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid node set null for right part reversed
        Node n3 = null;
        while (n2 != null) { // right part convert
            n3 = n2.next; // save node
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1; // save last node
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        // right part recover
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static Boolean isPalindromeByStack2(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> nodeStack = new Stack<>();
        while (right != null) {
            nodeStack.push(right);
            right = right.next;
        }
        while (!nodeStack.isEmpty()) {
            if (nodeStack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static Boolean isPalindromeByStack1(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node cur = head;
        Stack<Node> nodeStack = new Stack<>();
        // 先把链表放入栈中
        while (cur != null) {
            nodeStack.push(cur);
            cur = cur.next;
        }
        // 弹栈去和原链表对比是否相同
        while (head != null) {
            while (nodeStack.pop().value != cur.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
