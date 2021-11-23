package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;

public class AVLTreeNode {
    public AVLTreeNode(int key, AVLTreeNode parent, AVLTreeNode left, AVLTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public AVLTreeNode parent;
    public int key;
    public int balance;
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

    public void assertBalances() {
        if (right == null && left == null) {
            Assertions.assertEquals(0, balance);
            return;
        }

        if (right == null) {
            Assertions.assertEquals(-1, balance);
            left.assertBalances();
            return;
        }

        if (left == null) {
            Assertions.assertEquals(1, balance);
            right.assertBalances();
            return;
        }

        int l = left.height();
        int r = right.height();
        int diff = Math.abs(l - r);
        Assertions.assertTrue(diff <= 1);
        if (l > r)
            Assertions.assertEquals(-1, balance);
        if (r > l)
            Assertions.assertEquals(1, balance);
        if (r == l)
            Assertions.assertEquals(0, balance);

        left.assertBalances();
        right.assertBalances();
    }

    public void print(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        System.out.println(key);
        if (left != null) {
            left.print(spaces + 1);
        }

        if (right != null) {
            right.print(spaces + 1);
        }
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
