package com.ypan.comback.dong.tree;

import com.ypan.utils.TreeNode;

public class DiameterOfBinaryTree {
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepthDp(root);
        return maxDepth;

    }

    public int maxDepthDp(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepthDp(root.left);
        int right = maxDepthDp(root.right);
        int max = left + right;
        maxDepth = Math.max(maxDepth, max);
        return Math.max(left, right) + 1;
    }
}
