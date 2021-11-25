package com.thomasgassmann.exercises;

public class AugmentedBinarySearchTreeKthSmallestElement {
    public static AugmentedBinarySearchTreeNode kthSmallest(AugmentedBinarySearchTreeNode root, int k) {
        var current = root;
        while (current != null) {
            int size = current.left == null ? 0 : current.left.size;
            if (size + 1 == k)
                return current;
            if (size >= k) {
                current = current.left;
            } else {
                current = current.right;
                k -= 1 + size;
            }
        }

        return null;
    }
}
