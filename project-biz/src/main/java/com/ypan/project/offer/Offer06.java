package com.ypan.project.offer;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class Offer06 {
    @Data
      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        listNode.setNext(listNode1);
        listNode1.setNext(new ListNode(2));

        int[] ints = reversePrint(listNode);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }


    }

    public static int[] reversePrint(ListNode head) {

        ArrayList<Integer> integers = new ArrayList<>();
        Stack<ListNode> listNodes = new Stack<>();
        while (Objects.nonNull(head)) {
            listNodes.add(head);
            head = head.next;
        }
        while (!listNodes.isEmpty()) {
            ListNode pop = listNodes.pop();
            integers.add(pop.getVal());
        }
        int[] a = new int[integers.size()];

        if (integers.size()== 0) {
            return a;
        }
        for (int i = 0; i < integers.size(); i++) {
            a[i] = integers.get(i);
        }
        LinkedList<Integer> integers1 = new LinkedList<>();

        return a;
    }
}
