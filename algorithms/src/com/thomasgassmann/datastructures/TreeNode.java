package com.thomasgassmann.datastructures;

import java.util.ArrayList;

public class TreeNode {
    public TreeNode(int key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int key;
    public TreeNode left;
    public TreeNode right;

    public ArrayList<Integer> preorder() {
        var values = new ArrayList<Integer>();
        values.add(this.key);
        if (this.left != null)
            values.addAll(this.left.preorder());
        if (this.right != null)
            values.addAll(this.right.preorder());
        return values;
    }

    public ArrayList<Integer> postorder() {
        var left = this.left != null ? this.left.postorder() : new ArrayList<Integer>();
        if (this.right != null)
            left.addAll(this.right.postorder());
        left.add(this.key);
        return left;
    }

    public ArrayList<Integer> inorder() {
        var left = this.left != null ? this.left.inorder() : new ArrayList<Integer>();
        left.add(this.key);
        if (this.right != null)
            left.addAll(this.right.inorder());
        return left;
    }
}
