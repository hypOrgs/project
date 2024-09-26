package com.ypan.comback.list;

import com.ypan.utils.ListNode;

public class MyLinkedList {

    // 虚拟化头结点
    ListNode dummyHead;
    int size;

    public MyLinkedList() {
        size = 0;
        // 初始化虚拟头结点
        dummyHead = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = dummyHead;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        ListNode curr = dummyHead;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        ListNode newAdd = new ListNode(val);
        newAdd.next = curr.next;
        curr.next = newAdd;
        size++;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }


        ListNode curr = dummyHead;
        size--;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }

}

