package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

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

    public void assertLeftRightInequality() {
        if (right != null) {
            Assertions.assertTrue(right.key > this.key);
            right.assertLeftRightInequality();
        }

        if (left != null) {
            Assertions.assertTrue(left.key < this.key);
            left.assertLeftRightInequality();
        }
    }

    public int getBalance() {
        if (right == null && left == null) {
            return 0;
        }

        if (right == null) {
            return -1;
        }

        if (left == null) {
            return 1;
        }

        int l = left.height();
        int r = right.height();
        return l > r ? -1 : (r > l ? 1 : 0);
    }

    public void assertBalances(HashMap<AVLTreeNode, Integer> map) {
        if (right == null && left == null) {
            Assertions.assertEquals(0, map.get(this));
            return;
        }

        if (right == null) {
            Assertions.assertEquals(-1, map.get(this));
            left.assertBalances(map);
            return;
        }

        if (left == null) {
            Assertions.assertEquals(1, map.get(this));
            right.assertBalances(map);
            return;
        }

        int l = left.height();
        int r = right.height();
        int diff = Math.abs(l - r);
        Assertions.assertTrue(diff <= 1);
        left.assertBalances(map);
        right.assertBalances(map);
    }

    public void assertParents() {
        if (parent != null) {
            Assertions.assertTrue(parent.left == this || parent.right == this);
        }

        if (left != null)
            left.assertParents();
        if (right != null)
            right.assertParents();
    }

    public void assertHeights() {
        int l = left == null ? 0 : left.height();
        int r = right == null ? 0 : right.height();

        Assertions.assertTrue(Math.abs(l - r) <= 1);
        if (left != null)
            left.assertHeights();
        if (right != null)
            right.assertHeights();
    }

    public int height() {
        return 1 + Math.max(
                left == null ? 0 : left.height(),
                right == null ? 0 : right.height());
    }
}
