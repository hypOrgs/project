package com.ypan.comback.dong.tree;

import com.ypan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        tra(root);
        return res;
    }

    public void tra(TreeNode root) {

        if (root == null) {
            return;
        }

        res.add(root.val);
        tra(root.left);
        tra(root.right);

    }
}
