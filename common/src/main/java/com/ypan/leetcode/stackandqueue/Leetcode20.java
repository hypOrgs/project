package com.ypan.leetcode.stackandqueue;

import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {

        Stack<Character> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                characters.push(')');
            } else if (c == '[') {
                characters.push(']');
            } else if (c == '{') {
                characters.push('}');
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                if (characters.pop() != c) {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }
}
