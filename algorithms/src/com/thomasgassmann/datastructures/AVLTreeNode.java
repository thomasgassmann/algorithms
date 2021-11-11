package com.thomasgassmann.datastructures;

public class AVLTreeNode {
    public AVLTreeNode(int key, AVLTreeNode parent, AVLTreeNode left, AVLTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public AVLTreeNode parent;
    public int key;
    public AVLTreeNode left;
    public AVLTreeNode right;
}
