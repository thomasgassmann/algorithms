package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class AVLTreeTests {
    @Test
    public void checkAVLTree() {
        // Arrange
        var tree = new AVLTree();
        var random = new Random(100);
        var values = new int[200];
        for (int i = 0; i < values.length; i++)
            values[i] = random.nextInt(values.length);

        // Act
        for (int i = values.length - 1; i >= 0; i--) {
            tree.insert(values[i]);
            tree.getRoot().assertParents();
            tree.getRoot().assertBalances(tree.getBalances());
            tree.getRoot().assertLeftRightInequality();
            for (int j = values.length - 1; j >= i; j--) {
                Assertions.assertEquals(true, tree.contains(values[j]));
            }

            tree.getRoot().assertHeights();
        }

        // Assert
        var root = tree.getRoot();
        root.assertHeights();

        for (int i = 0; i < values.length; i++) {
            Assertions.assertEquals(true, tree.contains(values[i]));
        }
    }
}
