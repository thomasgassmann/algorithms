package com.thomasgassmann.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class AugmentedBinarySearchTreeTests {
    @Test
    public void checkAVLTreeWithSizes() {
        // Arrange
        var tree = new AugmentedBinarySearchTree();
        var random = new Random(42);
        var values = new int[250];
        for (int i = 0; i < values.length; i++)
            values[i] = random.nextInt(values.length);

        // Act
        for (int i = values.length - 1; i >= 0; i--) {
            int value = values[i];
            tree.insert(value);
            tree.getRoot().print(0);
            tree.getRoot().assertParents();
            tree.getRoot().assertBalances();
            tree.getRoot().assertLeftRightInequality();
            AugmentedBinarySearchTreeVerifySizes.assertSizes(tree);
            for (int j = values.length - 1; j >= i; j--) {
                Assertions.assertEquals(true, tree.contains(values[j]));
            }

            tree.getRoot().assertHeights();
        }

        // Assert
        var root = tree.getRoot();
        root.assertHeights();
        AugmentedBinarySearchTreeVerifySizes.assertSizes(tree);

        for (int i = 0; i < values.length; i++) {
            Assertions.assertEquals(true, tree.contains(values[i]));
        }
    }
}
