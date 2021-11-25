package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AugmentedBinarySearchTreeKthSmallestElementTests {
    @Test
    public void checkKthSmallestElement() {
        // Arrange
        var tree = new AugmentedBinarySearchTree();
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);

        // Act and assert
        assertKth(tree, 5, 10);
        assertKth(tree, 2, 7);
        assertKth(tree, 1, 3);
        assertKth(tree, 3, 8);
        assertKth(tree, 4, 9);
        assertKth(tree, 6, 12);
        assertKth(tree, 7, 15);
    }

    private void assertKth(AugmentedBinarySearchTree tree, int k, int n) {
        var res = AugmentedBinarySearchTreeKthSmallestElement.kthSmallest(tree.getRoot(), k);
        if (n < 0) {
            Assertions.assertNull(res);
            return;
        }

        Assertions.assertEquals(n, res.key);
    }
}
