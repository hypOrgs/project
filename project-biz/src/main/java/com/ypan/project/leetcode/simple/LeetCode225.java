package com.ypan.project.leetcode.simple;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {
    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {

            queue.add(x);
        }

        public int pop() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.remove());
            }
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {

            return queue.isEmpty();
        }
    }
}
