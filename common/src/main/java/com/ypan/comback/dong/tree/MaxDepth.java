package com.ypan.comback.dong.tree;


import com.ypan.utils.TreeNode;

public class MaxDepth {
    int res = 0;
    int depth = 0;
    public int maxDepth(TreeNode root) {

        tra(root);
        return res;

    }

    public void tra(TreeNode root) {

        if (root == null) {
            return;
        }

        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        tra(root.left);
        tra(root.right);
        depth--;
    }
}
