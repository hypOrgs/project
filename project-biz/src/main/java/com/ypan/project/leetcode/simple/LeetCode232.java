package com.ypan.project.leetcode.simple;

import io.swagger.models.auth.In;

import java.util.Stack;

public class LeetCode232 {

    public static final ThreadLocal theadLocal = new ThreadLocal();

    public static void main(String[] args) {
        theadLocal.set("1");
    }

    public class MyQueue {

        Stack<Integer> inStack = new Stack();
        Stack<Integer> outStack = new Stack<>();
        MyQueue() {
        }

        void push(int x) {
            inStack.push(x);
        }

        int pop() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        int peek() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        boolean empty() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.empty();
        }
    }
}
