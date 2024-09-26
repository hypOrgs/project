package com.ypan.comback.stackandqueue;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {

        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        check();
        return stackOut.pop();
    }

    public int peek() {
        check();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    public void check() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) stackOut.push(stackIn.pop());
    }
}
