package com.ypan.project.leetcode.simple;

import java.util.LinkedList;

/**
 * question:
 * 问题：给定一个只包括 ‘(‘，’)’，’{‘，’}’，’[‘，’]’ 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 有效括号
 * 1. 借助Stack 栈先进先出的特性，将左侧括号进入栈
 * 2. 当前character不是左侧括号时，则pop出来比对是否匹配
 * 3. 注意要判断边界问题（在pop前 memo的大小是否为0，在遍历后，meme的大小是否为0）
 */
public class LeetCode20 {
    public boolean isValid(String s) {

        LinkedList<Character> memo = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                memo.push(s.charAt(i));
            } else {
                if (memo.size() == 0) {
                    return false;
                }
                Character pop = memo.pop();
                Character c = null;
                if (pop.equals('(')) {
                    c = ')';
                }
                if (pop.equals('{')) {
                    c = '}';
                }
                if (pop.equals('[')) {
                    c = ']';
                }
                if (!c.equals(s.charAt(i))) {
                    return false;
                }
            }

        }
        if (memo.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        boolean valid = leetCode20.isValid("(())");
        System.out.println(valid);
    }
}
