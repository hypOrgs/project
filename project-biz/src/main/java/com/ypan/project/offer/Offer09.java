package com.ypan.project.offer;

import lombok.Data;

import java.util.Stack;

@Data
public class Offer09 {

    private Stack<Integer> tailStack = new Stack<>();

    private Stack<Integer> endStack = new Stack<>();

    public void appendTail(int value) {

        tailStack.push(value);

    }

    public int deleteHead() {

        if (!endStack.isEmpty()) {
            return endStack.pop();
        }

        if (tailStack.isEmpty()) {
            return -1;
        }

        while (!tailStack.isEmpty()) {
            endStack.push(tailStack.pop());
        }
        return endStack.pop();
    }
}
