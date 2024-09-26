package com.ypan.project.offer;

import java.util.Stack;

public class Offer30 {

    private Stack<Integer> stack;
    Integer min;
    public Offer30() {
        stack = new Stack<>();
        min = 0;
    }

    public void push(int x) {
        min = min < x ? min : x;
        stack.add(x);
        stack.push(x);
    }

    public void pop() {

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        stack.remove(min);
        return min;
    }
}
