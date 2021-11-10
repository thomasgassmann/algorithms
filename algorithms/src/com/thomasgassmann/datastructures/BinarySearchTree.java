package com.thomasgassmann.datastructures;

public class BinarySearchTree {
    private TreeNode _root;

    public void insert(int value) {
        if (_root == null) {
            _root = new TreeNode(value, null, null);
            return;
        }

        TreeNode prev = nearest(value);
        if (value > prev.key) {
            prev.right = new TreeNode(value, null, null);
        } else if (value < prev.key) {
            prev.left = new TreeNode(value, null, null);
        }
    }

    public boolean contains(int value) {
        TreeNode v = nearest(value);
        return v.key == value;
    }

    public void delete(int value) {
        TreeNode v = nearest(value);
        if (v.key != value) {
            return;
        }

        TreeNode parent = nearestParent(value);
        if (v.left == null && v.right == null) {
            setParentIfEqual(parent, v, null);
        } else if (v.left == null ^ v.right == null) {
            TreeNode w = v.left == null ? v.right : v.left;
            setParentIfEqual(parent, v, w);
        } else {
            TreeNode w = symmetricSuccessor(v);
            delete(w.key);

            v.key = w.key;
        }
    }

    private void setParentIfEqual(TreeNode parent, TreeNode v, TreeNode w) {
        if (parent.left == v) {
            parent.left = w;
        } else {
            parent.right = w;
        }
    }

    private TreeNode symmetricSuccessor(TreeNode v) {
        TreeNode w = v.right;
        TreeNode x = w.left;
        while (x != null) {
            w = x;
            x = w.left;
        }

        return w;
    }

    private TreeNode nearestParent(int value) {
        TreeNode v = _root;
        TreeNode prev = _root;
        TreeNode prevAbove = prev;
        while (v != null) {
            prevAbove = prev;
            prev = v;
            if (value == v.key) {
                return prevAbove;
            } else if (value < v.key) {
                v = v.left;
            } else {
                v = v.right;
            }
        }

        return prevAbove;
    }

    private TreeNode nearest(int value) {
        TreeNode parent = nearestParent(value);
        if (parent.right != null && parent.key < value) {
            return parent.right;
        } else if (parent.left != null && parent.key > value) {
            return parent.left;
        } else {
            return parent;
        }
    }

}
