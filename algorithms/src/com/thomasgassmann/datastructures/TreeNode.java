package com.thomasgassmann.datastructures;

public class TreeNode {
    public TreeNode(int key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int key;
    public TreeNode left;
    public TreeNode right;
}
