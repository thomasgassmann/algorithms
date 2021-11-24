package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;

public class AugmentedBinarySearchTreeVerifySizes {
    public static void assertSizes(AugmentedBinarySearchTree tree) {
        Assertions.assertTrue(verifySizes(tree.getRoot()));
    }

    public static boolean verifySizes(AugmentedBinarySearchTreeNode t) {
        if (t == null) {
            return true;
        }

        if (!verifySizes(t.left) || !verifySizes(t.right)) {
            return false;
        }

        return t.size == ((t.left != null ? t.left.size : 0)
                + (t.right != null ? t.right.size : 0) + 1);
    }
}
