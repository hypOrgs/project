package com.ypan.project.zhuoshen.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Tree {

    @Data
    public static class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    @Data
    @AllArgsConstructor
    public static class ReturnData {
        public Boolean isBST;
        public Integer min;
        public Integer max;
    }

    public static Boolean isBST1(Node head) {
        return process1(head).isBST;
    }

    public static ReturnData process1(Node x) {

        if (x == null) {
            return null;
        }

        ReturnData leftData = process1(x.left);
        ReturnData rightData = process1(x.right);

        // 走到这里左子树和右子树的信息都有了，接下来需要求一下x的信息才能使递归连接起来
        int min = x.value;
        int max = x.value;
        // 这里不要陷进去，就认为只要左子树或右子树返回的信息不为空，那么就是全量信息我们可以直接拿来用
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        // 先认为x是搜索二叉树，然后看是否会违规
        Boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= x.value)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= x.value)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }

    public static Node lca(Node head, Node o1, Node o2) {

        Map<Node, Node> fatherMap = new HashMap<>();
        // 放入头结点，头结点的父节点是他自己
        fatherMap.put(head, head);
        // 放入其他节点
        process3(head, fatherMap);
        // 新建存放节点o1向上引用节点链集合
        Set<Node> set1 = new HashSet<>();
        Node cur = o1;
        // 如果不等，说明cur节点不是头结点，引用节点链还有
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        // 节点o2往上走，每走一个和判断是否在set1里，第一个在set1里的节点，就是他们的最低公共祖先节点
        Node cur2 = o2;
        while (cur2 != fatherMap.get(o2)) {
            if (set1.contains(cur2)) {
                return cur2;
            }
            cur2 = fatherMap.get(cur2);
        }
        return null;
    }

    public static void process3(Node head, Map<Node, Node> fatherMap) {

        if (head == null) {
            return;
        }
        // 递归调用，把除了头结点之外，所有节点的父节点放入map中
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process3(head.left, fatherMap);
        process3(head.right, fatherMap);

    }
    public static Boolean isFBT(Node head) {
        FBTInfo fbtInfo = process2(head);
        Integer height = fbtInfo.height;
        Integer nodes = fbtInfo.nodes;
        if (nodes == (2 ^ height - 1)) {
            return true;
        }
        return false;
    }

    @Data
    @AllArgsConstructor
    public static class FBTInfo{
        private Integer height;
        private Integer nodes;
    }

    public static FBTInfo process2(Node x) {

        if (x ==null) {
            return new FBTInfo(0, 0);
        }

        FBTInfo leftData = process2(x.left);
        FBTInfo rightData = process2(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new FBTInfo(height, nodes);
    }

    public static void recPrint(Node head) {

        if (head == null) {
            return;
        }
        System.out.println(head.value);
        recPrint(head.left);
        recPrint(head.right);
    }

    public static void widthPrint(Node head) {

        if (head == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(head);
        while (!nodeQueue.isEmpty()) {
            Node cur = nodeQueue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                nodeQueue.add(cur.left);
            }
            if (cur.right != null) {
                nodeQueue.add(cur.right);
            }
        }
    }

    public static Integer getWidth(Node head) {

        if (head == null) {
            return 0;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        // 记录当前节点在第几层
        levelMap.put(head, 1);
        int curLevel = 1;
        // 当前层的节点数量
        int curLevelNodesCount = 0;
        // 最大宽度，默认最小值
        int max = Integer.MIN_VALUE;
        while (!nodeQueue.isEmpty()) {
            Node cur = nodeQueue.poll();
            // 当前节点的层级
            Integer curNodeLevel = levelMap.get(cur);
            // 如果层级数不变，节点数需要+1
            if (curNodeLevel == curLevel) {
                curLevelNodesCount++;
            } else { // 如果不等，说明已经进入下一层，计算一下上一层的最大节点数，保存在max中
                max = Math.max(max, curLevelNodesCount);
                curLevel++;
                // 进入新层，重置节点数
                curLevelNodesCount = 1;

            }
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                nodeQueue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                nodeQueue.add(cur.right);
            }
        }
        return max;
    }

    public static void preOrderUnRec(Node head) {
        if (head != null) {
            Stack<Node> nodes = new Stack<>();
            nodes.push(head);
            if (!nodes.isEmpty()) {
                Node cur = nodes.pop();
                System.out.println(cur.value);
                if (cur.right != null) {
                    nodes.push(cur.right);
                }
                if (cur.left != null) {
                    nodes.push(cur.left);
                }
            }
        }
    }

    public static Boolean isBST(Node head) {

        int preValue = Integer.MIN_VALUE;
        if (head == null) {
            return true;
        }
        // 判断左子树是否二叉搜索树
        Boolean isLeftBst = isBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        // 左子树是二叉树，继续检查，判断当前节点是否比上一次处理到的节点值大
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        // 如果右树是搜索二叉树，那么整棵树就是搜索二叉树了，否则就不是
        return isBST(head.right);
    }

    public static Boolean isCBT(Node head) {

        if (head == null) {
            return true;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        // 是否遇到过左右两个子节点不双全的节点
        Boolean leaf = false;
        // 定义两个变量分别代表两个节点
        Node l = null;
        Node r = null;
        nodeQueue.add(head);
        while (!nodeQueue.isEmpty()) {
            Node cur = nodeQueue.poll();
            l = cur.left;
            r = cur.right;

            if (
                    (leaf && (l != null || r != null)) // 如果左右节点不全，且当前节点不是叶子节点（得保证当前节点是叶子节点，否则此树就不是完全二叉树）
                            ||
                            (l == null && r != null) // 如果当前节点有右节点，没有左节点，那么此树不是完全二叉树
            ) {
                return false;
            }
            if (l != null) {
                nodeQueue.add(l);
            }
            if (r != null) {
                nodeQueue.add(r);
            }
            // 左右节点不双全
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static Boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    @Data
    @AllArgsConstructor
    public static class ReturnType {
        public Boolean isBalanced;
        public int height;
    }

    public static ReturnType process(Node x) {

        if (x == null) { // 空树的时候，是平衡树，高度为0
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(x.left); // 左树返回信息
        ReturnType rightData = process(x.right); // 右树返回信息

        // 左树或右树的高度+1就是当前整颗x树的高度
        int height = Math.max(leftData.height, rightData.height) + 1;
        // 同时满足三个条件才是平衡树
        Boolean isBalanced = leftData.isBalanced
                && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced, height);
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node.setLeft(node1);
        node.setRight(node2);
        recPrint(node);
    }
}
