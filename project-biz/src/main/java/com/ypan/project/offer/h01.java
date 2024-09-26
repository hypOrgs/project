package com.ypan.project.offer;

import java.awt.*;
import java.lang.annotation.ElementType;
import java.util.*;
import java.util.List;
import java.util.logging.Level;

public class h01 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.letterCombinations("23");
    }

     static class Solution {
        String[] map = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        List<String> res = new ArrayList<>();


        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            dfs(digits, new StringBuilder(), 0);
            return res;
        }


        void dfs(String digits, StringBuilder curStr, int index) {
            if (index == digits.length()) {
                res.add(curStr.toString());
                return;
            }
            char c = digits.charAt(index);
            int pos = c - '0';
            String map_string = map[pos];
            for (int i = 0; i < map_string.length(); i++) {
                curStr.append(map_string.charAt(i));
                dfs(digits, curStr, index + 1);
                curStr.deleteCharAt(curStr.length() - 1);
            }
        }
    }



    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> reList = new ArrayList<>();
        int length = nums.length;

        if (length == 1) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(nums[0]);
            reList.add(integerList);
            return reList;
        }
        return reList;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        int length = getLength(head);
        for (int i = 0; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    public static int getLength(ListNode head) {

        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public static ListNode removeNthFromEndTwo(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public String longestPalindrome(String s) {

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                hashSet.add(s.substring(i, j));
            }
        }
        // 保存所有的子串
        int count = 1;
        for (String s1 : hashSet) {

            Stack<Character> characterStack = new Stack<>();
            char[] array = s1.toCharArray();
            for (int i = 0; i < array.length; i++) {
                characterStack.push(array[i]);
            }

        }
        return "";
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                characterStack.push(')');
            } else if (chars[i] == '{') {
                characterStack.push('}');
            } else if (chars[i] == '[') {
                characterStack.push(']');
            } else {
                // 如果栈为空，说明字符串没有左括号的字符，肯定不符合题目
                if (characterStack.isEmpty()) {
                    return false;
                }
                if (characterStack.pop() != chars[i]) {
                    return false;
                }
            }
        }
        return characterStack.empty();
    }


    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }


    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }

    public int[] toSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        for (int j = 1; j <= n; j++) {
            if (hashSet.add(j)) {
                arrayList.add(j);
            }
        }
        return arrayList;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (head != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;


    }

    public static int majorityElement(int[] nums) {

        int count = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else {
                int integer = hashMap.get(nums[i]);
                hashMap.put(nums[i], integer + 1);
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {

            if (integerIntegerEntry.getValue() > count) {
                return integerIntegerEntry.getKey();
            }
        }
        return 0;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        while (headA != null && headB != null) {
            while (headB != null) {
                if (headA.val == headB.val) {
                    return headA;
                }
                headB = headB.next;
            }
            headA = headA.next;
        }
        return null;
    }


    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {

            if (slow == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    public int maxProfit(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public int singleNumber(int[] nums) {

        int e = 0;
        for (int i = 0; i < nums.length; i++) {
            e = e ^ nums[i];
        }
        return e;
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = maxDepth(root.left);
        int depth1 = maxDepth(root.right);
        return Math.max(depth, depth1) + 1;

    }


    public int depMethodLeft(TreeNode root, int count) {

        if (root == null) {
            return count;
        }

        if (root.left == null || root.right == null) {
            return ++count;
        }


        return depMethodLeft(root.left, count);

    }

    public int depMethodRight(TreeNode root, int count) {

        if (root == null) {
            return count;
        } else {
            ++count;
        }

        return depMethodRight(root.left, count);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
